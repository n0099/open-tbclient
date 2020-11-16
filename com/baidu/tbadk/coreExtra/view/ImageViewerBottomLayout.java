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
import com.baidu.tbadk.core.data.d;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class ImageViewerBottomLayout extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int fie = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView eVi;
    private ImageView eVk;
    private ImageView eVn;
    private TextView euD;
    private ImageUrlData fgQ;
    private a fib;
    private TextView fif;
    private ImageView fig;
    private View fih;
    private TextView fii;
    private LinearLayout fij;
    private ImageView fik;
    private c fil;
    private b fim;
    private String mUserId;

    /* loaded from: classes20.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    /* loaded from: classes20.dex */
    public interface b {
        void bxb();
    }

    /* loaded from: classes20.dex */
    public interface c {
        void bxc();
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.fib = null;
        this.fil = null;
        this.fim = null;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.fih = findViewById(R.id.unfold_root);
        this.fif = (TextView) findViewById(R.id.unfold_text);
        this.fig = (ImageView) findViewById(R.id.unfold_icon);
        this.fih.setVisibility(8);
        SvgManager.bqB().a(this.fig, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.fii = (TextView) findViewById(R.id.image_viewer_reply);
        this.fii.setText(R.string.image_viewer_reply);
        ap.setViewTextColor(this.fii, R.color.CAM_X0101);
        this.fii.setBackground(ap.aP(l.getDimens(context, R.dimen.tbds38), ap.getColor(R.color.CAM_X0615)));
        this.fij = (LinearLayout) findViewById(R.id.image_viewer_comment_and_agree);
        this.eVk = (ImageView) findViewById(R.id.comment_icon);
        WebPManager.a(this.eVk, R.drawable.icon_pure_card_comment22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.euD = (TextView) findViewById(R.id.comment_num);
        this.euD.setText("0");
        this.eVi = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.eVi.setResourceId(R.raw.lottie_agree_imageviewer, R.raw.lottie_disagree_imageviewer);
        this.eVi.setIsFromBigpic(true);
        this.eVi.setAgreeAlone(true);
        this.eVi.setAgreeAnimationResource();
        d dVar = new d();
        dVar.exI = 13;
        dVar.exO = 10;
        this.eVi.setStatisticData(dVar);
        this.eVn = (ImageView) findViewById(R.id.share_icon);
        WebPManager.a(this.eVn, R.drawable.icon_pure_card_share22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        this.fik = (ImageView) findViewById(R.id.download_icon);
        WebPManager.a(this.fik, R.drawable.icon_pure_share_download22, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
    }

    public void setExpandButtonListener(a aVar) {
        this.fib = aVar;
    }

    public void setOnShareImageListener(c cVar) {
        this.fil = cVar;
    }

    public void setOnDownloadImageListener(b bVar) {
        this.fim = bVar;
    }

    public void setOnReplyClickListener(View.OnClickListener onClickListener) {
        this.fii.setOnClickListener(onClickListener);
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void b(ImageUrlData imageUrlData) {
        this.fgQ = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.euD.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.eVi.setData(imageUrlData.agreeData);
            }
            this.fih.setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    private void initListener() {
        this.eVk.setOnClickListener(this);
        this.euD.setOnClickListener(this);
        this.eVn.setOnClickListener(this);
        this.fik.setOnClickListener(this);
        this.fih.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void jP(boolean z) {
        if (z) {
            this.fif.setText(getContext().getString(R.string.expand));
            SvgManager.bqB().a(this.fig, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
            this.fij.setVisibility(8);
            this.fii.setVisibility(8);
            return;
        }
        this.fif.setText(getContext().getString(R.string.fold));
        SvgManager.bqB().a(this.fig, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
        this.fij.setVisibility(0);
        this.fii.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eVk || view == this.euD) {
            if (this.fgQ != null) {
                ar arVar = new ar("c13685");
                arVar.w("tid", this.fgQ.threadId);
                arVar.dR("nid", this.fgQ.nid);
                arVar.dR("fid", this.fgQ.forumId);
                if (this.fgQ.from == "index") {
                    arVar.ak("obj_locate", 1);
                } else if (this.fgQ.from == "frs") {
                    arVar.ak("obj_locate", 2);
                } else if (this.fgQ.from == "pb") {
                    arVar.ak("obj_locate", 3);
                }
                TiebaStatic.log(arVar);
            }
            TiebaStatic.log(new ar("c12942").dR("obj_type", "2").dR("obj_locate", "12"));
            bwR();
        } else if (view == this.eVn) {
            if (this.fil != null) {
                this.fil.bxc();
            }
            if (this.fgQ != null) {
                TiebaStatic.log(new ar("c13857").dR("obj_type", "1").w("post_id", this.fgQ.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fgQ.forumId));
            }
        } else if (view == this.fik) {
            if (this.fim != null) {
                this.fim.bxb();
            }
            if (this.fgQ != null) {
                TiebaStatic.log(new ar("c13857").dR("obj_type", "2").w("post_id", this.fgQ.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fgQ.forumId));
            }
        } else if (view == this.fih) {
            if (this.fif.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.fif.setText(getContext().getString(R.string.fold));
                SvgManager.bqB().a(this.fig, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
                if (this.fib != null) {
                    this.fib.a(this, true);
                }
            } else {
                this.fif.setText(getContext().getString(R.string.expand));
                SvgManager.bqB().a(this.fig, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null);
                if (this.fib != null) {
                    this.fib.a(this, false);
                }
            }
            TiebaStatic.log(new ar("c13857").dR("obj_type", "6").w("post_id", this.fgQ.threadId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", this.fgQ.forumId));
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new ar("c13339").dR("uid", this.mUserId).w("post_id", this.fgQ.threadId));
        return true;
    }

    private void bwR() {
        if (this.fgQ != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.fgQ.threadId), String.valueOf(this.fgQ.postId), this.fgQ.mIsSeeHost, this.fgQ.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
