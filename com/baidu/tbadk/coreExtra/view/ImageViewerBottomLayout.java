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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int epC = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView dEA;
    private AgreeView edr;
    private ImageView eds;
    private ImageUrlData eop;
    private a epA;
    private TextView epD;
    private ImageView epE;
    private View epF;
    private LinearLayout epG;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.epA = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.epF = findViewById(R.id.unfold_root);
        this.epD = (TextView) findViewById(R.id.unfold_text);
        this.epE = (ImageView) findViewById(R.id.unfold_icon);
        this.epF.setVisibility(8);
        SvgManager.aWQ().a(this.epE, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.epG = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.eds = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aWQ().a(this.eds, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dEA = (TextView) findViewById(R.id.comment_num);
        this.dEA.setText("0");
        this.edr = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.edr.setIsFromBigpic(true);
        this.edr.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 13;
        cVar.dHw = 10;
        this.edr.setStatisticData(cVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.epA = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.edr != null) {
            this.edr.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.eop = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dEA.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.edr.setData(imageUrlData.agreeData);
            }
            if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.epF.setVisibility(4);
                return;
            } else {
                this.epF.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.eds.setOnClickListener(this);
        this.dEA.setOnClickListener(this);
        this.epF.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void hT(boolean z) {
        if (z) {
            this.epD.setText(getContext().getString(R.string.expand));
            SvgManager.aWQ().a(this.epE, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.epG.setVisibility(8);
            return;
        }
        this.epD.setText(getContext().getString(R.string.fold));
        SvgManager.aWQ().a(this.epE, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.epG.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eds || view == this.dEA) {
            if (this.eop != null) {
                ao aoVar = new ao("c13685");
                aoVar.s("tid", this.eop.threadId);
                aoVar.dk("nid", this.eop.nid);
                aoVar.dk("fid", this.eop.forumId);
                if (this.eop.from == "index") {
                    aoVar.ag("obj_locate", 1);
                } else if (this.eop.from == "frs") {
                    aoVar.ag("obj_locate", 2);
                } else if (this.eop.from == "pb") {
                    aoVar.ag("obj_locate", 3);
                }
                TiebaStatic.log(aoVar);
            }
            TiebaStatic.log(new ao("c12942").dk("obj_type", "2").dk("obj_locate", "12"));
            bdl();
        } else if (view == this.epF) {
            if (this.epD.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.epD.setText(getContext().getString(R.string.fold));
                SvgManager.aWQ().a(this.epE, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.epA != null) {
                    this.epA.a(this, true);
                    return;
                }
                return;
            }
            this.epD.setText(getContext().getString(R.string.expand));
            SvgManager.aWQ().a(this.epE, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.epA != null) {
                this.epA.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new ao("c13339").dk("uid", this.mUserId).s("post_id", this.eop.threadId));
        return true;
    }

    private void bdl() {
        if (this.eop != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.eop.threadId), String.valueOf(this.eop.postId), this.eop.mIsSeeHost, this.eop.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
