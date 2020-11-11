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
    public static final int fiY = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView eVZ;
    private ImageView eWa;
    private ImageView eWd;
    private TextView ewm;
    private ImageUrlData fhI;
    private a fiW;
    private TextView fiZ;
    private ImageView fja;
    private View fjb;
    private TextView fjc;
    private LinearLayout fjd;
    private ImageView fje;
    private c fjf;
    private b fjg;
    private String mUserId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void bxL();
    }

    /* loaded from: classes21.dex */
    public interface c {
        void bxM();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fiW = null;
        this.fjf = null;
        this.fjg = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fjb = findViewById(R.id.unfold_root);
        this.fiZ = (TextView) findViewById(R.id.unfold_text);
        this.fja = (ImageView) findViewById(R.id.unfold_icon);
        this.fjb.setVisibility(8);
        SvgManager.brn().a(this.fja, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.fjc = (TextView) findViewById(R.id.image_viewer_reply);
        this.fjc.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.fjc, R.color.cp_cont_a);
        this.fjc.setBackground(ap.aO(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.cp_mask_c_alpha25)));
        this.fjd = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.eWa = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.brn().a(this.eWa, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ewm = (TextView) findViewById(R.id.comment_num);
        this.ewm.setText("0");
        this.eVZ = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.eVZ.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.eVZ.setIsFromBigpic(true);
        this.eVZ.setAgreeAlone(true);
        this.eVZ.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ezt = 13;
        cVar.ezz = 10;
        this.eVZ.setStatisticData(cVar);
        this.eWd = (ImageView) findViewById(R.id.share_icon);
        SvgManager.brn().a(this.eWd, R.drawable.ic_icon_pure_share24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.fje = (ImageView) findViewById(R.id.download_icon);
        SvgManager.brn().a(this.fje, R.drawable.ic_icon_pure_download24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    public void setExpandButtonListener(a aVar) {
        this.fiW = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fjf = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fjg = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fjc.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.fhI = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.ewm.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.eVZ.setData(imageUrlData.agreeData);
            }
            this.fjb.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.eWa.setOnClickListener(this);
        this.ewm.setOnClickListener(this);
        this.eWd.setOnClickListener(this);
        this.fje.setOnClickListener(this);
        this.fjb.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void jO(boolean z) {
        if (z) {
            this.fiZ.setText(getContext().getString(R.string.expand));
            SvgManager.brn().a(this.fja, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.fjd.setVisibility(8);
            this.fjc.setVisibility(8);
            return;
        }
        this.fiZ.setText(getContext().getString(R.string.fold));
        SvgManager.brn().a(this.fja, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.fjd.setVisibility(0);
        this.fjc.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eWa || view == this.ewm) {
            if (this.fhI != null) {
                aq aqVar = new aq("c13685");
                aqVar.w("tid", this.fhI.threadId);
                aqVar.dR("nid", this.fhI.nid);
                aqVar.dR("fid", this.fhI.forumId);
                if (this.fhI.from == "index") {
                    aqVar.al("obj_locate", 1);
                } else if (this.fhI.from == "frs") {
                    aqVar.al("obj_locate", 2);
                } else if (this.fhI.from == "pb") {
                    aqVar.al("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            TiebaStatic.log(new aq("c12942").dR("obj_type", "2").dR("obj_locate", "12"));
            bxB();
        } else if (view == this.eWd) {
            if (this.fjf != null) {
                this.fjf.bxM();
            }
            if (this.fhI != null) {
                TiebaStatic.log(new aq("c13857").dR("obj_type", "1").w("post_id", this.fhI.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fhI.forumId));
            }
        } else if (view == this.fje) {
            if (this.fjg != null) {
                this.fjg.bxL();
            }
            if (this.fhI != null) {
                TiebaStatic.log(new aq("c13857").dR("obj_type", "2").w("post_id", this.fhI.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fhI.forumId));
            }
        } else if (view == this.fjb) {
            if (this.fiZ.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fiZ.setText(getContext().getString(R.string.fold));
                SvgManager.brn().a(this.fja, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.fiW != null) {
                    this.fiW.a(this, true);
                }
            } else {
                this.fiZ.setText(getContext().getString(R.string.expand));
                SvgManager.brn().a(this.fja, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.fiW != null) {
                    this.fiW.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dR("obj_type", "6").w("post_id", this.fhI.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fhI.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dR("uid", this.mUserId).w("post_id", this.fhI.threadId));
        return true;
    }

    private void bxB() {
        if (this.fhI != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.fhI.threadId), String.valueOf(this.fhI.postId), this.fhI.mIsSeeHost, this.fhI.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
