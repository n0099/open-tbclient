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
/* loaded from: classes9.dex */
public class NestedScrollHeader extends RelativeLayout {
    CustomMessageListener fZF;
    View.OnClickListener gTT;
    private TbImageView haG;
    private TextView haH;
    private a haI;
    private Bitmap haJ;
    private CustomMessageListener mSyncFinishListener;

    /* loaded from: classes9.dex */
    public interface a {
        void Cg(String str);
    }

    public NestedScrollHeader(@NonNull Context context) {
        this(context, null);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NestedScrollHeader.this.haG == view) {
                    Object tag = NestedScrollHeader.this.haG.getTag(R.id.homepage_mission_entrance_url);
                    if (tag instanceof String) {
                        String str = (String) tag;
                        if (!TextUtils.isEmpty(str)) {
                            if (NestedScrollHeader.this.haI != null) {
                                NestedScrollHeader.this.haI.Cg(str);
                            }
                            NestedScrollHeader.this.bNO();
                        }
                    }
                } else if (NestedScrollHeader.this.haH == view) {
                    TiebaStatic.log(new an(CommonStatisticKey.SEARCH_BAR_CLICK).X("obj_type", 1));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new SquareSearchActivityConfig(NestedScrollHeader.this.getContext(), "", false)));
                }
            }
        };
        this.fZF = new CustomMessageListener(2921396) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                NestedScrollHeader.this.setSearchHint(TbSingleton.getInstance().getHotSearch());
            }
        };
        this.mSyncFinishListener = new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && NestedScrollHeader.this.haG.getVisibility() == 0) {
                    NestedScrollHeader.this.bNN();
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_presenlize_scroll_header, (ViewGroup) this, true);
        this.haG = (TbImageView) findViewById(R.id.task);
        this.haG.setOnClickListener(this.gTT);
        this.haH = (TextView) findViewById(R.id.search);
        this.haH.setOnClickListener(this.gTT);
        onChangeSkinType();
        MessageManager.getInstance().registerListener(this.fZF);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
        if (MissionEntranceSwitch.isOn()) {
            this.haG.setVisibility(0);
            bNN();
            return;
        }
        this.haG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNN() {
        final String missionEntranceUrl = TbSingleton.getInstance().getMissionEntranceUrl();
        String missionEntranceIcon = TbSingleton.getInstance().getMissionEntranceIcon();
        if (TextUtils.isEmpty(missionEntranceUrl) || TextUtils.isEmpty(missionEntranceIcon)) {
            this.haJ = null;
            this.haG.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
            this.haG.setImageResource(R.drawable.btn_home_task_n);
            return;
        }
        c.gr().a(missionEntranceIcon, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.homepage.framework.indicator.NestedScrollHeader.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null || aVar.getRawBitmap() == null || aVar.getRawBitmap().isRecycled()) {
                    NestedScrollHeader.this.haJ = null;
                    NestedScrollHeader.this.haG.setImageResource(R.drawable.btn_home_task_n);
                    NestedScrollHeader.this.haG.setTag(R.id.homepage_mission_entrance_url, "https://haokan.baidu.com/activity/h5/vault?productid=8&tab=act&tag=shitu&pd=1&source=1-101-1&idfrom=1&tbioswk=1");
                    return;
                }
                NestedScrollHeader.this.haJ = aVar.getRawBitmap();
                NestedScrollHeader.this.haG.setImageBitmap(NestedScrollHeader.this.haJ);
                NestedScrollHeader.this.haG.setTag(R.id.homepage_mission_entrance_url, missionEntranceUrl);
                NestedScrollHeader.this.haG.invalidate();
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
        this.haI = aVar;
    }

    public void setSearchHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.haH.setText(str);
        }
    }

    public void ay(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            if (this.haG.getVisibility() == 0 && this.haG.getAlpha() != f) {
                this.haG.setAlpha(f);
            }
            if (this.haH.getAlpha() != f) {
                this.haH.setAlpha(f);
            }
        }
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.haH, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.haH, R.drawable.task_scroll_search_bg);
        this.haH.setCompoundDrawablesWithIntrinsicBounds(SvgManager.aGG().a(R.drawable.icon_pure_search_import16_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.haJ == null) {
            am.setImageResource(this.haG, R.drawable.btn_home_task_n);
        } else if (this.haG != null) {
            this.haG.setImageBitmap(this.haJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.fZF);
        MessageManager.getInstance().registerListener(this.mSyncFinishListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.fZF);
        MessageManager.getInstance().unRegisterListener(this.mSyncFinishListener);
    }

    public ImageView getTaskView() {
        return this.haG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNO() {
        an anVar = new an("c13422");
        anVar.X("obj_type", 2);
        anVar.X("obj_locate", 1);
        anVar.X(TiebaInitialize.Params.AB_TAG, TbSingleton.getInstance().getHomePageStyleAbTest());
        TiebaStatic.log(anVar);
    }
}
