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
    public static final int eGq = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView dTF;
    private ImageUrlData eFd;
    private a eGo;
    private TextView eGr;
    private ImageView eGs;
    private View eGt;
    private TextView eGu;
    private LinearLayout eGv;
    private ImageView eGw;
    private c eGx;
    private b eGy;
    private ImageView etA;
    private AgreeView etw;
    private ImageView etx;
    private String mUserId;

    /* loaded from: classes15.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes15.dex */
    public interface b {
        void bpO();
    }

    /* loaded from: classes15.dex */
    public interface c {
        void bpP();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.eGo = null;
        this.eGx = null;
        this.eGy = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.eGt = findViewById(R.id.unfold_root);
        this.eGr = (TextView) findViewById(R.id.unfold_text);
        this.eGs = (ImageView) findViewById(R.id.unfold_icon);
        this.eGt.setVisibility(8);
        SvgManager.bjq().a(this.eGs, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eGu = (TextView) findViewById(R.id.image_viewer_reply);
        this.eGu.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.eGu, R.color.cp_cont_a);
        this.eGu.setBackground(ap.aO(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.cp_mask_c_alpha25)));
        this.eGv = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.etx = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.bjq().a(this.etx, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dTF = (TextView) findViewById(R.id.comment_num);
        this.dTF.setText("0");
        this.etw = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.etw.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.etw.setIsFromBigpic(true);
        this.etw.setAgreeAlone(true);
        this.etw.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 13;
        cVar.dWQ = 10;
        this.etw.setStatisticData(cVar);
        this.etA = (ImageView) findViewById(R.id.share_icon);
        SvgManager.bjq().a(this.etA, R.drawable.ic_icon_pure_share24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eGw = (ImageView) findViewById(R.id.download_icon);
        SvgManager.bjq().a(this.eGw, R.drawable.ic_icon_pure_download24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    public void setExpandButtonListener(a aVar) {
        this.eGo = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.eGx = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.eGy = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.eGu.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.eFd = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dTF.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.etw.setData(imageUrlData.agreeData);
            }
            this.eGt.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.etx.setOnClickListener(this);
        this.dTF.setOnClickListener(this);
        this.etA.setOnClickListener(this);
        this.eGw.setOnClickListener(this);
        this.eGt.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void iV(boolean z) {
        if (z) {
            this.eGr.setText(getContext().getString(R.string.expand));
            SvgManager.bjq().a(this.eGs, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.eGv.setVisibility(8);
            this.eGu.setVisibility(8);
            return;
        }
        this.eGr.setText(getContext().getString(R.string.fold));
        SvgManager.bjq().a(this.eGs, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eGv.setVisibility(0);
        this.eGu.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.etx || view == this.dTF) {
            if (this.eFd != null) {
                aq aqVar = new aq("c13685");
                aqVar.u("tid", this.eFd.threadId);
                aqVar.dD("nid", this.eFd.nid);
                aqVar.dD("fid", this.eFd.forumId);
                if (this.eFd.from == "index") {
                    aqVar.ai("obj_locate", 1);
                } else if (this.eFd.from == "frs") {
                    aqVar.ai("obj_locate", 2);
                } else if (this.eFd.from == "pb") {
                    aqVar.ai("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            TiebaStatic.log(new aq("c12942").dD("obj_type", "2").dD("obj_locate", "12"));
            bpE();
        } else if (view == this.etA) {
            if (this.eGx != null) {
                this.eGx.bpP();
            }
            if (this.eFd != null) {
                TiebaStatic.log(new aq("c13857").dD("obj_type", "1").u("post_id", this.eFd.threadId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", this.eFd.forumId));
            }
        } else if (view == this.eGw) {
            if (this.eGy != null) {
                this.eGy.bpO();
            }
            if (this.eFd != null) {
                TiebaStatic.log(new aq("c13857").dD("obj_type", "2").u("post_id", this.eFd.threadId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", this.eFd.forumId));
            }
        } else if (view == this.eGt) {
            if (this.eGr.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.eGr.setText(getContext().getString(R.string.fold));
                SvgManager.bjq().a(this.eGs, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eGo != null) {
                    this.eGo.a(this, true);
                }
            } else {
                this.eGr.setText(getContext().getString(R.string.expand));
                SvgManager.bjq().a(this.eGs, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eGo != null) {
                    this.eGo.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dD("obj_type", "6").u("post_id", this.eFd.threadId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fid", this.eFd.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dD("uid", this.mUserId).u("post_id", this.eFd.threadId));
        return true;
    }

    private void bpE() {
        if (this.eFd != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.eFd.threadId), String.valueOf(this.eFd.postId), this.eFd.mIsSeeHost, this.eFd.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
