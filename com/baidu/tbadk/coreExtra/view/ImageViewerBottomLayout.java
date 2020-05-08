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
    public static final int dSI = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dHF;
    private TextView dHG;
    private ImageView dHH;
    private ImageUrlData dRk;
    private a dSG;
    private TextView dSJ;
    private ImageView dSK;
    private View dSL;
    private boolean dSM;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dSG = null;
        this.dSM = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dSG = null;
        this.dSM = true;
        this.dSM = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.dSL = findViewById(R.id.unfold_root);
        this.dSJ = (TextView) findViewById(R.id.unfold_text);
        this.dSK = (ImageView) findViewById(R.id.unfold_icon);
        this.dSL.setVisibility(8);
        SvgManager.aOR().a(this.dSK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dHH = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aOR().a(this.dHH, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dHG = (TextView) findViewById(R.id.comment_num);
        this.dHG.setText("0");
        this.dHF = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dHF.setIsFromBigpic(true);
        this.dHF.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.dmX = 13;
        dVar.dnd = 10;
        this.dHF.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dSG = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dHF != null) {
            this.dHF.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dRk = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dHG.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dHF.setData(imageUrlData.agreeData);
            }
            if (!this.dSM) {
                this.dSL.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.dSL.setVisibility(4);
                return;
            } else {
                this.dSL.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dHH.setOnClickListener(this);
        this.dHG.setOnClickListener(this);
        this.dSL.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void ho(boolean z) {
        if (z) {
            this.dSJ.setText(getContext().getString(R.string.expand));
            SvgManager.aOR().a(this.dSK, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dSJ.setText(getContext().getString(R.string.fold));
        SvgManager.aOR().a(this.dSK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dHH || view == this.dHG) {
            TiebaStatic.log(new an("c12942").cI("obj_type", "2").cI("obj_locate", "12"));
            aUY();
        } else if (view == this.dSL) {
            if (this.dSJ.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dSJ.setText(getContext().getString(R.string.fold));
                SvgManager.aOR().a(this.dSK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dSG != null) {
                    this.dSG.a(this, true);
                    return;
                }
                return;
            }
            this.dSJ.setText(getContext().getString(R.string.expand));
            SvgManager.aOR().a(this.dSK, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dSG != null) {
                this.dSG.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cI("uid", this.mUserId).t("post_id", this.dRk.threadId));
        return true;
    }

    private void aUY() {
        if (this.dRk != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dRk.threadId), String.valueOf(this.dRk.postId), this.dRk.mIsSeeHost, this.dRk.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
