package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int eGu = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView dTJ;
    private ImageUrlData eFh;
    private ImageView eGA;
    private c eGB;
    private b eGC;
    private a eGs;
    private TextView eGv;
    private ImageView eGw;
    private View eGx;
    private TextView eGy;
    private LinearLayout eGz;
    private AgreeView etA;
    private ImageView etB;
    private ImageView etE;
    private String mUserId;

    /* loaded from: classes15.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void bpP();
    }

    /* loaded from: classes15.dex */
    public interface c {
        void bpQ();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.eGs = null;
        this.eGB = null;
        this.eGC = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.eGx = findViewById(R.id.unfold_root);
        this.eGv = (TextView) findViewById(R.id.unfold_text);
        this.eGw = (ImageView) findViewById(R.id.unfold_icon);
        this.eGx.setVisibility(8);
        SvgManager.bjq().a(this.eGw, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eGy = (TextView) findViewById(R.id.image_viewer_reply);
        this.eGy.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.eGy, R.color.cp_cont_a);
        this.eGy.setBackground(ap.aO(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.cp_mask_c_alpha25)));
        this.eGz = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.etB = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.bjq().a(this.etB, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dTJ = (TextView) findViewById(R.id.comment_num);
        this.dTJ.setText("0");
        this.etA = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.etA.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.etA.setIsFromBigpic(true);
        this.etA.setAgreeAlone(true);
        this.etA.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWO = 13;
        cVar.dWU = 10;
        this.etA.setStatisticData(cVar);
        this.etE = (ImageView) findViewById(R.id.share_icon);
        SvgManager.bjq().a(this.etE, R.drawable.ic_icon_pure_share24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eGA = (ImageView) findViewById(R.id.download_icon);
        SvgManager.bjq().a(this.eGA, R.drawable.ic_icon_pure_download24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    public void setExpandButtonListener(a aVar) {
        this.eGs = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.eGB = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.eGC = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.eGy.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.eFh = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dTJ.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.etA.setData(imageUrlData.agreeData);
            }
            this.eGx.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.etB.setOnClickListener(this);
        this.dTJ.setOnClickListener(this);
        this.etE.setOnClickListener(this);
        this.eGA.setOnClickListener(this);
        this.eGx.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void iX(boolean z) {
        if (z) {
            this.eGv.setText(getContext().getString(R.string.expand));
            SvgManager.bjq().a(this.eGw, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.eGz.setVisibility(8);
            this.eGy.setVisibility(8);
            return;
        }
        this.eGv.setText(getContext().getString(R.string.fold));
        SvgManager.bjq().a(this.eGw, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eGz.setVisibility(0);
        this.eGy.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.etB || view == this.dTJ) {
            if (this.eFh != null) {
                aq aqVar = new aq("c13685");
                aqVar.u("tid", this.eFh.threadId);
                aqVar.dD("nid", this.eFh.nid);
                aqVar.dD("fid", this.eFh.forumId);
                if (this.eFh.from == "index") {
                    aqVar.ai("obj_locate", 1);
                } else if (this.eFh.from == "frs") {
                    aqVar.ai("obj_locate", 2);
                } else if (this.eFh.from == "pb") {
                    aqVar.ai("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            TiebaStatic.log(new aq("c12942").dD("obj_type", "2").dD("obj_locate", "12"));
            bpF();
        } else if (view == this.etE) {
            if (this.eGB != null) {
                this.eGB.bpQ();
            }
            if (this.eFh != null) {
                TiebaStatic.log(new aq("c13857").dD("obj_type", "1").u("post_id", this.eFh.threadId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", this.eFh.forumId));
            }
        } else if (view == this.eGA) {
            if (this.eGC != null) {
                this.eGC.bpP();
            }
            if (this.eFh != null) {
                TiebaStatic.log(new aq("c13857").dD("obj_type", "2").u("post_id", this.eFh.threadId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", this.eFh.forumId));
            }
        } else if (view == this.eGx) {
            if (this.eGv.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.eGv.setText(getContext().getString(R.string.fold));
                SvgManager.bjq().a(this.eGw, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eGs != null) {
                    this.eGs.a(this, true);
                }
            } else {
                this.eGv.setText(getContext().getString(R.string.expand));
                SvgManager.bjq().a(this.eGw, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eGs != null) {
                    this.eGs.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dD("obj_type", "6").u("post_id", this.eFh.threadId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", this.eFh.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dD("uid", this.mUserId).u("post_id", this.eFh.threadId));
        return true;
    }

    private void bpF() {
        if (this.eFh != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.eFh.threadId), String.valueOf(this.eFh.postId), this.eFh.mIsSeeHost, this.eFh.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
