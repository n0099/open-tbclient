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
/* loaded from: classes21.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int fdf = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView eQk;
    private ImageView eQl;
    private ImageView eQo;
    private TextView eqt;
    private ImageUrlData fbR;
    private a fdd;
    private TextView fdg;
    private ImageView fdh;
    private View fdi;
    private TextView fdj;
    private LinearLayout fdk;
    private ImageView fdl;
    private c fdm;
    private b fdn;
    private String mUserId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void bvm();
    }

    /* loaded from: classes21.dex */
    public interface c {
        void bvn();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fdd = null;
        this.fdm = null;
        this.fdn = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fdi = findViewById(R.id.unfold_root);
        this.fdg = (TextView) findViewById(R.id.unfold_text);
        this.fdh = (ImageView) findViewById(R.id.unfold_icon);
        this.fdi.setVisibility(8);
        SvgManager.boN().a(this.fdh, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.fdj = (TextView) findViewById(R.id.image_viewer_reply);
        this.fdj.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.fdj, R.color.cp_cont_a);
        this.fdj.setBackground(ap.aO(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.cp_mask_c_alpha25)));
        this.fdk = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.eQl = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.boN().a(this.eQl, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eqt = (TextView) findViewById(R.id.comment_num);
        this.eqt.setText("0");
        this.eQk = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.eQk.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.eQk.setIsFromBigpic(true);
        this.eQk.setAgreeAlone(true);
        this.eQk.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.etA = 13;
        cVar.etG = 10;
        this.eQk.setStatisticData(cVar);
        this.eQo = (ImageView) findViewById(R.id.share_icon);
        SvgManager.boN().a(this.eQo, R.drawable.ic_icon_pure_share24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.fdl = (ImageView) findViewById(R.id.download_icon);
        SvgManager.boN().a(this.fdl, R.drawable.ic_icon_pure_download24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    public void setExpandButtonListener(a aVar) {
        this.fdd = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fdm = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fdn = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fdj.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.fbR = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.eqt.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.eQk.setData(imageUrlData.agreeData);
            }
            this.fdi.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.eQl.setOnClickListener(this);
        this.eqt.setOnClickListener(this);
        this.eQo.setOnClickListener(this);
        this.fdl.setOnClickListener(this);
        this.fdi.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void jF(boolean z) {
        if (z) {
            this.fdg.setText(getContext().getString(R.string.expand));
            SvgManager.boN().a(this.fdh, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.fdk.setVisibility(8);
            this.fdj.setVisibility(8);
            return;
        }
        this.fdg.setText(getContext().getString(R.string.fold));
        SvgManager.boN().a(this.fdh, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.fdk.setVisibility(0);
        this.fdj.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eQl || view == this.eqt) {
            if (this.fbR != null) {
                aq aqVar = new aq("c13685");
                aqVar.w("tid", this.fbR.threadId);
                aqVar.dR("nid", this.fbR.nid);
                aqVar.dR("fid", this.fbR.forumId);
                if (this.fbR.from == "index") {
                    aqVar.aj("obj_locate", 1);
                } else if (this.fbR.from == "frs") {
                    aqVar.aj("obj_locate", 2);
                } else if (this.fbR.from == "pb") {
                    aqVar.aj("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            TiebaStatic.log(new aq("c12942").dR("obj_type", "2").dR("obj_locate", "12"));
            bvc();
        } else if (view == this.eQo) {
            if (this.fdm != null) {
                this.fdm.bvn();
            }
            if (this.fbR != null) {
                TiebaStatic.log(new aq("c13857").dR("obj_type", "1").w("post_id", this.fbR.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fbR.forumId));
            }
        } else if (view == this.fdl) {
            if (this.fdn != null) {
                this.fdn.bvm();
            }
            if (this.fbR != null) {
                TiebaStatic.log(new aq("c13857").dR("obj_type", "2").w("post_id", this.fbR.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fbR.forumId));
            }
        } else if (view == this.fdi) {
            if (this.fdg.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fdg.setText(getContext().getString(R.string.fold));
                SvgManager.boN().a(this.fdh, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.fdd != null) {
                    this.fdd.a(this, true);
                }
            } else {
                this.fdg.setText(getContext().getString(R.string.expand));
                SvgManager.boN().a(this.fdh, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.fdd != null) {
                    this.fdd.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dR("obj_type", "6").w("post_id", this.fbR.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fbR.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dR("uid", this.mUserId).w("post_id", this.fbR.threadId));
        return true;
    }

    private void bvc() {
        if (this.fbR != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.fbR.threadId), String.valueOf(this.fbR.postId), this.fbR.mIsSeeHost, this.fbR.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
