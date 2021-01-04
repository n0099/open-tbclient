package com.baidu.tieba.ala;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.g.o;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView bmO;
    private String bvS;
    private FrameLayout cFY;
    private TextView eLt;
    private View gpT;
    private LinearLayout gpU;
    private TextView grN;
    private TextView grO;
    private TextView grP;
    private BdListView grQ;
    private a grR;
    private com.baidu.tieba.ala.data.e grS;
    private com.baidu.tieba.ala.g.g grT;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private CustomMessageListener aBj = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private o grU = new o() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.g.o
        public void b(com.baidu.tieba.ala.data.e eVar) {
            AlaRedPacketSnatchResultActivity.this.a(eVar);
        }

        @Override // com.baidu.tieba.ala.g.o
        public void v(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.h.sdk_net_fail_tip);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            if (StringUtils.isNullObject(this.mRedPacketId)) {
                finish();
                return;
            }
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            setContentView(a.g.ala_red_packet_snatch_result_view);
            initView();
            this.grT = new com.baidu.tieba.ala.g.g(getPageContext(), this.grU);
            this.grT.ay(this.mRedPacketId, this.mLiveId, this.bvS);
            MessageManager.getInstance().registerListener(this.aBj);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bvS = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.gpT = findViewById(a.f.rp_result_root_bg);
        this.gpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.f.rp_result_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.cFY = (FrameLayout) findViewById(a.f.rp_result_root_container);
        this.bmO = (HeadImageView) findViewById(a.f.rp_result_user_icon);
        this.bmO.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bmO.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bmO.setIsRound(true);
        this.bmO.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bmO.setAutoChangeStyle(true);
        this.bmO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grN = (TextView) findViewById(a.f.p_result_top10_desc);
        this.eLt = (TextView) findViewById(a.f.p_result_user_name);
        this.grO = (TextView) findViewById(a.f.p_result_loot_amount);
        this.gpU = (LinearLayout) findViewById(a.f.rp_result_content);
        this.grP = (TextView) findViewById(a.f.p_result_send_gift);
        this.grQ = (BdListView) findViewById(a.f.p_result_listview);
        this.grP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bRI();
            }
        });
        this.gpU.setVisibility(8);
        this.grP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRI() {
        ak akVar = new ak();
        akVar.aMe = -1;
        akVar.aMf = -1;
        akVar.aMh = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
    }

    public void a(com.baidu.tieba.ala.data.e eVar) {
        String str;
        this.grS = eVar;
        this.gpU.setVisibility(0);
        this.grP.setVisibility(0);
        if (!StringUtils.isNullObject(eVar.portrait)) {
            m.a(this.bmO, eVar.portrait, true, false);
        }
        this.eLt.setText(eVar.userName);
        if (eVar.gUv) {
            String format = String.format(getPageContext().getResources().getString(a.h.snatch_red_packet_amount_desc), Long.valueOf(eVar.gUd));
            this.grP.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpU.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds184);
            this.gpU.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.h.snatch_red_packet_failed_1);
            this.grP.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gpU.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.gpU.setLayoutParams(layoutParams2);
            str = string;
        }
        this.grO.setText(str);
        W(eVar.gUw);
    }

    private void W(ArrayList<e.a> arrayList) {
        this.grR = new a(getPageContext().getPageActivity(), arrayList);
        this.grQ.setAdapter((ListAdapter) this.grR);
        this.grR.notifyDataSetChanged();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mi(configuration.orientation == 2);
    }

    private void mi(boolean z) {
        if (z) {
            i.ae(this.cFY);
            this.cFY.setScaleX(0.85f);
            this.cFY.setScaleY(0.85f);
            return;
        }
        i.af(this.cFY);
        this.cFY.setScaleX(1.0f);
        this.cFY.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.grT != null) {
            this.grT.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aBj);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends BaseAdapter {
        private ArrayList<e.a> grW;
        private Context mContext;

        public a(Context context, ArrayList<e.a> arrayList) {
            this.mContext = context;
            this.grW = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.grW != null) {
                return this.grW.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: uM */
        public e.a getItem(int i) {
            if (this.grW != null) {
                return this.grW.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_loot_user_item, viewGroup, false);
                bVar2.cbK = (HeadImageView) view.findViewById(a.f.rp_user_list_icon);
                bVar2.cbK.setIsRound(true);
                bVar2.cbK.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
                bVar2.cbK.setAutoChangeStyle(true);
                bVar2.cbK.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.grX = (TextView) view.findViewById(a.f.rp_user_list_name);
                bVar2.grY = (TextView) view.findViewById(a.f.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    m.a(bVar.cbK, item.portrait, true, false);
                }
                bVar.grX.setText(item.userName);
                bVar.grY.setText(String.format(this.mContext.getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes11.dex */
    private static class b {
        public HeadImageView cbK;
        public TextView grX;
        public TextView grY;

        private b() {
        }
    }
}
