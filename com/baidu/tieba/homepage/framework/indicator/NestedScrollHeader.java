package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.t.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class NestedScrollHeader extends RelativeLayout {
    private CustomMessageListener bzl;
    CustomMessageListener fdb;
    View.OnClickListener gab;
    private TbImageView ghI;
    private TextView ghJ;
    private a ghK;
    private Bitmap ghL;
    private View view;

    /* loaded from: classes4.dex */
    public interface a {
        void yD(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gab = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NestedScrollHeader.this.ghI == view) {
                    Object tag = NestedScrollHeader.this.ghI.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (!TextUtils.isEmpty(str)) {
                            if (NestedScrollHeader.this.ghK != null) {
                                NestedScrollHeader.this.ghK.yD(str);
                            }
                            NestedScrollHeader.this.bwx();
                        }
                    }
                } else if (NestedScrollHeader.this.ghJ == view) {
                    TiebaStatic.log(new an("c10378").P("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            }
        };
        this.fdb = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        this.bzl = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.ghI.getVisibility() == 0) {
                    NestedScrollHeader.this.bww();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.ghI = (TbImageView) findViewById(R.id.task);
        this.ghI.setOnClickListener(this.gab);
        this.ghJ = (TextView) findViewById(R.id.search);
        this.ghJ.setOnClickListener(this.gab);
        this.view = findViewById(R.id.view);
        onChangeSkinType();
        MessageManager.getInstance().registerListener(this.fdb);
        MessageManager.getInstance().registerListener(this.bzl);
        if (ao.iN()) {
            this.ghI.setVisibility(0);
            bww();
            return;
        }
        this.ghI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bww() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.ghL = null;
            this.ghI.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.ghI.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        com.baidu.adp.lib.f.c.iE().a(missionEntranceIcon, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.nK() == null || aVar.nK().isRecycled()) {
                    NestedScrollHeader.this.ghL = null;
                    NestedScrollHeader.this.ghI.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.ghI.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.ghL = aVar.nK();
                NestedScrollHeader.this.ghI.setImageBitmap(NestedScrollHeader.this.ghL);
                NestedScrollHeader.this.ghI.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.ghI.invalidate();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    public void setEntranceJumpListener(a aVar) {
        this.ghK = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ghJ.setText(str);
        }
    }

    public void aG(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.ghI.getVisibility() == 0 && this.ghI.getAlpha() != f) {
                this.ghI.setAlpha(f);
            }
            if (this.ghJ.getAlpha() != f) {
                this.ghJ.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        am.l(this, R.color.cp_bg_line_h);
        am.j(this.ghJ, R.color.cp_cont_d);
        am.k(this.ghJ, R.drawable.task_scroll_search_bg);
        am.l(this.view, R.color.cp_bg_line_h);
        this.ghJ.setCompoundDrawablesWithIntrinsicBounds(SvgManager.ajv().a(R.drawable.icon_pure_search_import_n_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.ghL == null) {
            am.c(this.ghI, (int) R.drawable.btn_home_task_n);
        } else if (this.ghI != null) {
            this.ghI.setImageBitmap(this.ghL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fdb);
        MessageManager.getInstance().registerListener(this.bzl);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fdb);
        MessageManager.getInstance().unRegisterListener(this.bzl);
    }

    public ImageView getTaskView() {
        return this.ghI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwx() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 2);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
