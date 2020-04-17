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
    public static final int dSD = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dHB;
    private TextView dHC;
    private ImageView dHD;
    private ImageUrlData dRf;
    private a dSB;
    private TextView dSE;
    private ImageView dSF;
    private View dSG;
    private boolean dSH;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dSB = null;
        this.dSH = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dSB = null;
        this.dSH = true;
        this.dSH = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.dSG = findViewById(R.id.unfold_root);
        this.dSE = (TextView) findViewById(R.id.unfold_text);
        this.dSF = (ImageView) findViewById(R.id.unfold_icon);
        this.dSG.setVisibility(8);
        SvgManager.aOU().a(this.dSF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dHD = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aOU().a(this.dHD, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dHC = (TextView) findViewById(R.id.comment_num);
        this.dHC.setText("0");
        this.dHB = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dHB.setIsFromBigpic(true);
        this.dHB.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmT = 13;
        dVar.dmZ = 10;
        this.dHB.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dSB = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dHB != null) {
            this.dHB.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dRf = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dHC.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dHB.setData(imageUrlData.agreeData);
            }
            if (!this.dSH) {
                this.dSG.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.dSG.setVisibility(4);
                return;
            } else {
                this.dSG.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dHD.setOnClickListener(this);
        this.dHC.setOnClickListener(this);
        this.dSG.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void ho(boolean z) {
        if (z) {
            this.dSE.setText(getContext().getString(R.string.expand));
            SvgManager.aOU().a(this.dSF, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dSE.setText(getContext().getString(R.string.fold));
        SvgManager.aOU().a(this.dSF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dHD || view == this.dHC) {
            TiebaStatic.log(new an("c12942").cI("obj_type", "2").cI("obj_locate", "12"));
            aVa();
        } else if (view == this.dSG) {
            if (this.dSE.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dSE.setText(getContext().getString(R.string.fold));
                SvgManager.aOU().a(this.dSF, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dSB != null) {
                    this.dSB.a(this, true);
                    return;
                }
                return;
            }
            this.dSE.setText(getContext().getString(R.string.expand));
            SvgManager.aOU().a(this.dSF, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dSB != null) {
                this.dSB.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cI("uid", this.mUserId).t("post_id", this.dRf.threadId));
        return true;
    }

    private void aVa() {
        if (this.dRf != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dRf.threadId), String.valueOf(this.dRf.postId), this.dRf.mIsSeeHost, this.dRf.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
