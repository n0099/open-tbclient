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
    public static final int dsg = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dhf;
    private TextView dhg;
    private ImageView dhh;
    private ImageUrlData dqH;
    private a dse;
    private TextView dsh;
    private ImageView dsi;
    private View dsj;
    private boolean dsk;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dse = null;
        this.dsk = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dse = null;
        this.dsk = true;
        this.dsk = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.dsj = findViewById(R.id.unfold_root);
        this.dsh = (TextView) findViewById(R.id.unfold_text);
        this.dsi = (ImageView) findViewById(R.id.unfold_icon);
        this.dsj.setVisibility(8);
        SvgManager.aGA().a(this.dsi, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhh = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aGA().a(this.dhh, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhg = (TextView) findViewById(R.id.comment_num);
        this.dhg.setText("0");
        this.dhf = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dhf.setIsFromBigpic(true);
        this.dhf.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNA = 13;
        dVar.cNG = 10;
        this.dhf.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dse = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dhf != null) {
            this.dhf.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dqH = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dhg.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dhf.setData(imageUrlData.agreeData);
            }
            if (!this.dsk) {
                this.dsj.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.dsj.setVisibility(4);
                return;
            } else {
                this.dsj.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dhh.setOnClickListener(this);
        this.dhg.setOnClickListener(this);
        this.dsj.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void gp(boolean z) {
        if (z) {
            this.dsh.setText(getContext().getString(R.string.expand));
            SvgManager.aGA().a(this.dsi, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dsh.setText(getContext().getString(R.string.fold));
        SvgManager.aGA().a(this.dsi, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhh || view == this.dhg) {
            TiebaStatic.log(new an("c12942").cy("obj_type", "2").cy("obj_locate", "12"));
            aMw();
        } else if (view == this.dsj) {
            if (this.dsh.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dsh.setText(getContext().getString(R.string.fold));
                SvgManager.aGA().a(this.dsi, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dse != null) {
                    this.dse.a(this, true);
                    return;
                }
                return;
            }
            this.dsh.setText(getContext().getString(R.string.expand));
            SvgManager.aGA().a(this.dsi, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dse != null) {
                this.dse.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cy("uid", this.mUserId).s("post_id", this.dqH.threadId));
        return true;
    }

    private void aMw() {
        if (this.dqH != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dqH.threadId), String.valueOf(this.dqH.postId), this.dqH.mIsSeeHost, this.dqH.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
