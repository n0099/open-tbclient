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
    public static final int dsv = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds130);
    private AgreeView dht;
    private TextView dhu;
    private ImageView dhv;
    private ImageUrlData dqV;
    private a dss;
    private TextView dsw;
    private ImageView dsx;
    private View dsy;
    private boolean dsz;
    private String mUserId;

    /* loaded from: classes8.dex */
    public interface a {
        void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z);
    }

    public ImageViewerBottomLayout(Context context) {
        super(context);
        this.dss = null;
        this.dsz = true;
        init(context);
        initListener();
    }

    public ImageViewerBottomLayout(Context context, boolean z) {
        super(context);
        this.dss = null;
        this.dsz = true;
        this.dsz = z;
        init(context);
        initListener();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.image_viewer_bottom_layout, (ViewGroup) this, true);
        this.dsy = findViewById(R.id.unfold_root);
        this.dsw = (TextView) findViewById(R.id.unfold_text);
        this.dsx = (ImageView) findViewById(R.id.unfold_icon);
        this.dsy.setVisibility(8);
        SvgManager.aGC().a(this.dsx, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhv = (ImageView) findViewById(R.id.comment_icon);
        SvgManager.aGC().a(this.dhv, R.drawable.icon_pure_imageviewer_comment24_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
        this.dhu = (TextView) findViewById(R.id.comment_num);
        this.dhu.setText("0");
        this.dht = (AgreeView) findViewById(R.id.agree_and_disagreeview);
        this.dht.setIsFromBigpic(true);
        this.dht.setAgreeAnimationResource();
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cNC = 13;
        dVar.cNI = 10;
        this.dht.setStatisticData(dVar);
    }

    public void setExpandButtonListener(a aVar) {
        this.dss = aVar;
    }

    public void setUserId(String str) {
        this.mUserId = str;
    }

    public void setIsBjhDynamic(boolean z) {
        if (this.dht != null) {
            this.dht.setAgreeAlone(z);
        }
    }

    public void b(ImageUrlData imageUrlData) {
        this.dqV = imageUrlData;
        if (imageUrlData != null && imageUrlData.agreeData != null) {
            setVisibility(0);
            if (imageUrlData.commentNum != null) {
                this.dhu.setText(imageUrlData.commentNum);
            }
            if (imageUrlData.agreeData != null) {
                this.dht.setData(imageUrlData.agreeData);
            }
            if (!this.dsz) {
                this.dsy.setVisibility(4);
                return;
            } else if (TextUtils.isEmpty(imageUrlData.richTextArray) || "[]".equals(imageUrlData.richTextArray)) {
                this.dsy.setVisibility(4);
                return;
            } else {
                this.dsy.setVisibility(0);
                return;
            }
        }
        setVisibility(8);
    }

    private void initListener() {
        this.dhv.setOnClickListener(this);
        this.dhu.setOnClickListener(this);
        this.dsy.setOnClickListener(this);
        setOnTouchListener(this);
    }

    public void gp(boolean z) {
        if (z) {
            this.dsw.setText(getContext().getString(R.string.expand));
            SvgManager.aGC().a(this.dsx, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            return;
        }
        this.dsw.setText(getContext().getString(R.string.fold));
        SvgManager.aGC().a(this.dsx, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dhv || view == this.dhu) {
            TiebaStatic.log(new an("c12942").cy("obj_type", "2").cy("obj_locate", "12"));
            aMz();
        } else if (view == this.dsy) {
            if (this.dsw.getText().toString().equals(getContext().getString(R.string.expand))) {
                this.dsw.setText(getContext().getString(R.string.fold));
                SvgManager.aGC().a(this.dsx, R.drawable.icon_pure_unfold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
                if (this.dss != null) {
                    this.dss.a(this, true);
                    return;
                }
                return;
            }
            this.dsw.setText(getContext().getString(R.string.expand));
            SvgManager.aGC().a(this.dsx, R.drawable.icon_pure_fold12_svg, R.color.cp_cont_a, (SvgManager.SvgResourceStateType) null);
            if (this.dss != null) {
                this.dss.a(this, false);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TiebaStatic.log(new an("c13339").cy("uid", this.mUserId).s("post_id", this.dqV.threadId));
        return true;
    }

    private void aMz() {
        if (this.dqV != null) {
            PbActivityConfig createHistoryCfg = new PbActivityConfig(getContext()).createHistoryCfg(String.valueOf(this.dqV.threadId), String.valueOf(this.dqV.postId), this.dqV.mIsSeeHost, this.dqV.mIsReserver, null);
            createHistoryCfg.setJumpToCommentArea(true);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createHistoryCfg));
        }
    }
}
