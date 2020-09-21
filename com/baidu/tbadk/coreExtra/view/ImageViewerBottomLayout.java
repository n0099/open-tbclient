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
/* loaded from: classes20.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int eIB = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private TextView dVT;
    private ImageUrlData eHo;
    private TextView eIC;
    private ImageView eID;
    private View eIE;
    private TextView eIF;
    private LinearLayout eIG;
    private ImageView eIH;
    private c eII;
    private b eIJ;
    private a eIz;
    private AgreeView evE;
    private ImageView evF;
    private ImageView evI;
    private String mUserId;

    /* loaded from: classes20.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void bqJ();
    }

    /* loaded from: classes20.dex */
    public interface c {
        void bqK();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.eIz = null;
        this.eII = null;
        this.eIJ = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.eIE = findViewById(R.id.unfold_root);
        this.eIC = (TextView) findViewById(R.id.unfold_text);
        this.eID = (ImageView) findViewById(R.id.unfold_icon);
        this.eIE.setVisibility(8);
        SvgManager.bkl().a(this.eID, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eIF = (TextView) findViewById(R.id.image_viewer_reply);
        this.eIF.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.eIF, R.color.cp_cont_a);
        this.eIF.setBackground(ap.aO(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.cp_mask_c_alpha25)));
        this.eIG = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.evF = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.bkl().a(this.evF, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dVT = (TextView) findViewById(R.id.comment_num);
        this.dVT.setText("0");
        this.evE = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.evE.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.evE.setIsFromBigpic(true);
        this.evE.setAgreeAlone(true);
        this.evE.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 13;
        cVar.dZe = 10;
        this.evE.setStatisticData(cVar);
        this.evI = (ImageView) findViewById(R.id.share_icon);
        SvgManager.bkl().a(this.evI, R.drawable.ic_icon_pure_share24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eIH = (ImageView) findViewById(R.id.download_icon);
        SvgManager.bkl().a(this.eIH, R.drawable.ic_icon_pure_download24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    public void setExpandButtonListener(a aVar) {
        this.eIz = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.eII = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.eIJ = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.eIF.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.eHo = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dVT.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.evE.setData(imageUrlData.agreeData);
            }
            this.eIE.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.evF.setOnClickListener(this);
        this.dVT.setOnClickListener(this);
        this.evI.setOnClickListener(this);
        this.eIH.setOnClickListener(this);
        this.eIE.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void iU(boolean z) {
        if (z) {
            this.eIC.setText(getContext().getString(R.string.expand));
            SvgManager.bkl().a(this.eID, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.eIG.setVisibility(8);
            this.eIF.setVisibility(8);
            return;
        }
        this.eIC.setText(getContext().getString(R.string.fold));
        SvgManager.bkl().a(this.eID, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eIG.setVisibility(0);
        this.eIF.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.evF || view == this.dVT) {
            if (this.eHo != null) {
                aq aqVar = new aq("c13685");
                aqVar.u("tid", this.eHo.threadId);
                aqVar.dF("nid", this.eHo.nid);
                aqVar.dF("fid", this.eHo.forumId);
                if (this.eHo.from == "index") {
                    aqVar.ai("obj_locate", 1);
                } else if (this.eHo.from == "frs") {
                    aqVar.ai("obj_locate", 2);
                } else if (this.eHo.from == "pb") {
                    aqVar.ai("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            TiebaStatic.log(new aq("c12942").dF("obj_type", "2").dF("obj_locate", "12"));
            bqz();
        } else if (view == this.evI) {
            if (this.eII != null) {
                this.eII.bqK();
            }
            if (this.eHo != null) {
                TiebaStatic.log(new aq("c13857").dF("obj_type", "1").u("post_id", this.eHo.threadId).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", this.eHo.forumId));
            }
        } else if (view == this.eIH) {
            if (this.eIJ != null) {
                this.eIJ.bqJ();
            }
            if (this.eHo != null) {
                TiebaStatic.log(new aq("c13857").dF("obj_type", "2").u("post_id", this.eHo.threadId).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", this.eHo.forumId));
            }
        } else if (view == this.eIE) {
            if (this.eIC.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.eIC.setText(getContext().getString(R.string.fold));
                SvgManager.bkl().a(this.eID, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eIz != null) {
                    this.eIz.a(this, true);
                }
            } else {
                this.eIC.setText(getContext().getString(R.string.expand));
                SvgManager.bkl().a(this.eID, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eIz != null) {
                    this.eIz.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dF("obj_type", "6").u("post_id", this.eHo.threadId).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", this.eHo.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dF("uid", this.mUserId).u("post_id", this.eHo.threadId));
        return true;
    }

    private void bqz() {
        if (this.eHo != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.eHo.threadId), String.valueOf(this.eHo.postId), this.eHo.mIsSeeHost, this.eHo.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
