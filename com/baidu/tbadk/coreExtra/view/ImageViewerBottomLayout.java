package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int dsI = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dhG;
    private TextView dhH;
    private ImageView dhI;
    private ImageUrlData dri;
    private a dsG;
    private TextView dsJ;
    private ImageView dsK;
    private View dsL;
    private boolean dsM;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dsG = null;
        this.dsM = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dsG = null;
        this.dsM = true;
        this.dsM = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.dsL = findViewById(R.id.unfold_root);
        this.dsJ = (TextView) findViewById(R.id.unfold_text);
        this.dsK = (ImageView) findViewById(R.id.unfold_icon);
        this.dsL.setVisibility(8);
        SvgManager.aGG().a(this.dsK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhI = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aGG().a(this.dhI, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhH = (TextView) findViewById(R.id.comment_num);
        this.dhH.setText("0");
        this.dhG = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dhG.setIsFromBigpic(true);
        this.dhG.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNP = 13;
        dVar.cNV = 10;
        this.dhG.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dsG = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dhG != null) {
            this.dhG.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dri = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dhH.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dhG.setData(imageUrlData.agreeData);
            }
            if (!this.dsM) {
                this.dsL.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.dsL.setVisibility(4);
                return;
            } else {
                this.dsL.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dhI.setOnClickListener(this);
        this.dhH.setOnClickListener(this);
        this.dsL.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void gq(boolean z) {
        if (z) {
            this.dsJ.setText(getContext().getString(R.string.expand));
            SvgManager.aGG().a(this.dsK, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dsJ.setText(getContext().getString(R.string.fold));
        SvgManager.aGG().a(this.dsK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhI || view == this.dhH) {
            TiebaStatic.log(new an("c12942").cx("obj_type", "2").cx("obj_locate", "12"));
            aMD();
        } else if (view == this.dsL) {
            if (this.dsJ.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dsJ.setText(getContext().getString(R.string.fold));
                SvgManager.aGG().a(this.dsK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dsG != null) {
                    this.dsG.a(this, true);
                    return;
                }
                return;
            }
            this.dsJ.setText(getContext().getString(R.string.expand));
            SvgManager.aGG().a(this.dsK, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dsG != null) {
                this.dsG.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cx("uid", this.mUserId).s("post_id", this.dri.threadId));
        return true;
    }

    private void aMD() {
        if (this.dri != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dri.threadId), String.valueOf(this.dri.postId), this.dri.mIsSeeHost, this.dri.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
