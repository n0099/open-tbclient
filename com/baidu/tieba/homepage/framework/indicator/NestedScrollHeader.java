package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.t.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class NestedScrollHeader extends RelativeLayout {
    private CustomMessageListener byN;
    View.OnClickListener fYk;
    CustomMessageListener fbv;
    private TbImageView gfR;
    private TextView gfS;
    private a gfT;
    private View view;

    /* loaded from: classes4.dex */
    public interface a {
        void ye(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fYk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NestedScrollHeader.this.gfR == view) {
                    Object tag = NestedScrollHeader.this.gfR.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (!TextUtils.isEmpty(str)) {
                            if (NestedScrollHeader.this.gfT != null) {
                                NestedScrollHeader.this.gfT.ye(str);
                            }
                            NestedScrollHeader.this.bvJ();
                        }
                    }
                } else if (NestedScrollHeader.this.gfS == view) {
                    TiebaStatic.log(new an("c10378").P("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2015003, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            }
        };
        this.fbv = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        this.byN = new CustomMessageListener(2001371) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.gfR.getVisibility() == 0) {
                    NestedScrollHeader.this.bvI();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.gfR = (TbImageView) findViewById(R.id.task);
        this.gfR.setOnClickListener(this.fYk);
        this.gfS = (TextView) findViewById(R.id.search);
        this.gfS.setOnClickListener(this.fYk);
        this.view = findViewById(R.id.view);
        onChangeSkinType();
        MessageManager.getInstance().registerListener(this.fbv);
        MessageManager.getInstance().registerListener(this.byN);
        if (ao.iN()) {
            this.gfR.setVisibility(0);
            bvI();
            return;
        }
        this.gfR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.gfR.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.gfR.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        com.baidu.adp.lib.f.c.iE().a(missionEntranceIcon, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.nK() == null || aVar.nK().isRecycled()) {
                    NestedScrollHeader.this.gfR.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.gfR.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.gfR.setImageBitmap(aVar.nK());
                NestedScrollHeader.this.gfR.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
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
        this.gfT = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gfS.setText(str);
        }
    }

    public void aF(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.gfR.getVisibility() == 0 && this.gfR.getAlpha() != f) {
                this.gfR.setAlpha(f);
            }
            if (this.gfS.getAlpha() != f) {
                this.gfS.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        am.l(this, R.color.cp_bg_line_d);
        am.j(this.gfS, R.color.cp_cont_d);
        am.k(this.gfS, R.drawable.task_scroll_search_bg);
        am.l(this.view, R.color.cp_bg_line_d);
        this.gfS.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_home_search_n), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this.gfR, (int) R.drawable.btn_home_task_n);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fbv);
        MessageManager.getInstance().registerListener(this.byN);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fbv);
        MessageManager.getInstance().unRegisterListener(this.byN);
    }

    public ImageView getTaskView() {
        return this.gfR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        an anVar = new an("c13422");
        anVar.P("obj_type", 2);
        anVar.P("obj_locate", 1);
        anVar.P("ab_tag", TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
