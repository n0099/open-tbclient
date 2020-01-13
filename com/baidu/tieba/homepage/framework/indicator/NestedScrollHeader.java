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
import com.baidu.adp.lib.e.c;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.SquareSearchActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class NestedScrollHeader extends RelativeLayout {
    private CustomMessageListener cDL;
    CustomMessageListener fWH;
    View.OnClickListener gQy;
    private TbImageView gXj;
    private TextView gXk;
    private a gXl;
    private Bitmap gXm;

    /* loaded from: classes7.dex */
    public interface a {
        void BP(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gQy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NestedScrollHeader.this.gXj == view) {
                    Object tag = NestedScrollHeader.this.gXj.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (!TextUtils.isEmpty(str)) {
                            if (NestedScrollHeader.this.gXl != null) {
                                NestedScrollHeader.this.gXl.BP(str);
                            }
                            NestedScrollHeader.this.bLU();
                        }
                    }
                } else if (NestedScrollHeader.this.gXk == view) {
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).Z("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            }
        };
        this.fWH = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        this.cDL = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.gXj.getVisibility() == 0) {
                    NestedScrollHeader.this.bLT();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.gXj = (TbImageView) findViewById(R.id.task);
        this.gXj.setOnClickListener(this.gQy);
        this.gXk = (TextView) findViewById(R.id.search);
        this.gXk.setOnClickListener(this.gQy);
        onChangeSkinType();
        MessageManager.getInstance().registerListener(this.fWH);
        MessageManager.getInstance().registerListener(this.cDL);
        if (MissionEntranceSwitch.isOn()) {
            this.gXj.setVisibility(0);
            bLT();
            return;
        }
        this.gXj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLT() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.gXm = null;
            this.gXj.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.gXj.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        c.gr().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.gXm = null;
                    NestedScrollHeader.this.gXj.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.gXj.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.gXm = aVar.getRawBitmap();
                NestedScrollHeader.this.gXj.setImageBitmap(NestedScrollHeader.this.gXm);
                NestedScrollHeader.this.gXj.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.gXj.invalidate();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onProgressUpdate(Object... objArr) {
                super.onProgressUpdate(objArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
            }
        }, null);
    }

    public void setEntranceJumpListener(a aVar) {
        this.gXl = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gXk.setText(str);
        }
    }

    public void az(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.gXj.getVisibility() == 0 && this.gXj.getAlpha() != f) {
                this.gXj.setAlpha(f);
            }
            if (this.gXk.getAlpha() != f) {
                this.gXk.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gXk, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.gXk, R.drawable.task_scroll_search_bg);
        this.gXk.setCompoundDrawablesWithIntrinsicBounds(SvgManager.aEp().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.gXm == null) {
            am.setImageResource(this.gXj, R.drawable.btn_home_task_n);
        } else if (this.gXj != null) {
            this.gXj.setImageBitmap(this.gXm);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fWH);
        MessageManager.getInstance().registerListener(this.cDL);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fWH);
        MessageManager.getInstance().unRegisterListener(this.cDL);
    }

    public ImageView getTaskView() {
        return this.gXj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLU() {
        an anVar = new an("c13422");
        anVar.Z("obj_type", 2);
        anVar.Z("obj_locate", 1);
        anVar.Z(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
