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
    public static final int eUI = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView eHO;
    private ImageView eHP;
    private ImageView eHS;
    private ImageUrlData eTv;
    private a eUG;
    private TextView eUJ;
    private ImageView eUK;
    private View eUL;
    private TextView eUM;
    private LinearLayout eUN;
    private ImageView eUO;
    private c eUP;
    private b eUQ;
    private TextView ehV;
    private String mUserId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void btt();
    }

    /* loaded from: classes21.dex */
    public interface c {
        void btu();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.eUG = null;
        this.eUP = null;
        this.eUQ = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.eUL = findViewById(R.id.unfold_root);
        this.eUJ = (TextView) findViewById(R.id.unfold_text);
        this.eUK = (ImageView) findViewById(R.id.unfold_icon);
        this.eUL.setVisibility(8);
        SvgManager.bmU().a(this.eUK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eUM = (TextView) findViewById(R.id.image_viewer_reply);
        this.eUM.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.eUM, R.color.cp_cont_a);
        this.eUM.setBackground(ap.aN(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.cp_mask_c_alpha25)));
        this.eUN = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.eHP = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.bmU().a(this.eHP, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.ehV = (TextView) findViewById(R.id.comment_num);
        this.ehV.setText("0");
        this.eHO = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.eHO.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.eHO.setIsFromBigpic(true);
        this.eHO.setAgreeAlone(true);
        this.eHO.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 13;
        cVar.elg = 10;
        this.eHO.setStatisticData(cVar);
        this.eHS = (ImageView) findViewById(R.id.share_icon);
        SvgManager.bmU().a(this.eHS, R.drawable.ic_icon_pure_share24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eUO = (ImageView) findViewById(R.id.download_icon);
        SvgManager.bmU().a(this.eUO, R.drawable.ic_icon_pure_download24, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    public void setExpandButtonListener(a aVar) {
        this.eUG = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.eUP = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.eUQ = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.eUM.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.eTv = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.ehV.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.eHO.setData(imageUrlData.agreeData);
            }
            this.eUL.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.eHP.setOnClickListener(this);
        this.ehV.setOnClickListener(this);
        this.eHS.setOnClickListener(this);
        this.eUO.setOnClickListener(this);
        this.eUL.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void js(boolean z) {
        if (z) {
            this.eUJ.setText(getContext().getString(R.string.expand));
            SvgManager.bmU().a(this.eUK, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            this.eUN.setVisibility(8);
            this.eUM.setVisibility(8);
            return;
        }
        this.eUJ.setText(getContext().getString(R.string.fold));
        SvgManager.bmU().a(this.eUK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.eUN.setVisibility(0);
        this.eUM.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eHP || view == this.ehV) {
            if (this.eTv != null) {
                aq aqVar = new aq("c13685");
                aqVar.u("tid", this.eTv.threadId);
                aqVar.dK("nid", this.eTv.nid);
                aqVar.dK("fid", this.eTv.forumId);
                if (this.eTv.from == "index") {
                    aqVar.aj("obj_locate", 1);
                } else if (this.eTv.from == "frs") {
                    aqVar.aj("obj_locate", 2);
                } else if (this.eTv.from == "pb") {
                    aqVar.aj("obj_locate", 3);
                }
                TiebaStatic.log(aqVar);
            }
            TiebaStatic.log(new aq("c12942").dK("obj_type", "2").dK("obj_locate", "12"));
            btj();
        } else if (view == this.eHS) {
            if (this.eUP != null) {
                this.eUP.btu();
            }
            if (this.eTv != null) {
                TiebaStatic.log(new aq("c13857").dK("obj_type", "1").u("post_id", this.eTv.threadId).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", this.eTv.forumId));
            }
        } else if (view == this.eUO) {
            if (this.eUQ != null) {
                this.eUQ.btt();
            }
            if (this.eTv != null) {
                TiebaStatic.log(new aq("c13857").dK("obj_type", "2").u("post_id", this.eTv.threadId).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", this.eTv.forumId));
            }
        } else if (view == this.eUL) {
            if (this.eUJ.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.eUJ.setText(getContext().getString(R.string.fold));
                SvgManager.bmU().a(this.eUK, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eUG != null) {
                    this.eUG.a(this, true);
                }
            } else {
                this.eUJ.setText(getContext().getString(R.string.expand));
                SvgManager.bmU().a(this.eUK, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.eUG != null) {
                    this.eUG.a(this, false);
                }
            }
            TiebaStatic.log(new aq("c13857").dK("obj_type", "6").u("post_id", this.eTv.threadId).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fid", this.eTv.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new aq("c13339").dK("uid", this.mUserId).u("post_id", this.eTv.threadId));
        return true;
    }

    private void btj() {
        if (this.eTv != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.eTv.threadId), String.valueOf(this.eTv.postId), this.eTv.mIsSeeHost, this.eTv.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
