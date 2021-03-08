package com.baidu.tieba.ala;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.live.data.ao;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.g.o;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView bmU;
    private String bwh;
    private FrameLayout cFi;
    private TextView eKp;
    private View gpP;
    private LinearLayout gpQ;
    private TextView grM;
    private TextView grN;
    private TextView grO;
    private BdListView grP;
    private a grQ;
    private com.baidu.tieba.ala.data.e grR;
    private com.baidu.tieba.ala.g.g grS;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private CustomMessageListener axL = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private o grT = new o() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.g.o
        public void b(com.baidu.tieba.ala.data.e eVar) {
            AlaRedPacketSnatchResultActivity.this.a(eVar);
        }

        @Override // com.baidu.tieba.ala.g.o
        public void A(int i, String str) {
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
            this.grS = new com.baidu.tieba.ala.g.g(getPageContext(), this.grT);
            this.grS.ay(this.mRedPacketId, this.mLiveId, this.bwh);
            MessageManager.getInstance().registerListener(this.axL);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bwh = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.gpP = findViewById(a.f.rp_result_root_bg);
        this.gpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.cFi = (FrameLayout) findViewById(a.f.rp_result_root_container);
        this.bmU = (HeadImageView) findViewById(a.f.rp_result_user_icon);
        this.bmU.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bmU.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bmU.setIsRound(true);
        this.bmU.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.bmU.setAutoChangeStyle(true);
        this.bmU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grM = (TextView) findViewById(a.f.p_result_top10_desc);
        this.eKp = (TextView) findViewById(a.f.p_result_user_name);
        this.grN = (TextView) findViewById(a.f.p_result_loot_amount);
        this.gpQ = (LinearLayout) findViewById(a.f.rp_result_content);
        this.grO = (TextView) findViewById(a.f.p_result_send_gift);
        this.grP = (BdListView) findViewById(a.f.p_result_listview);
        this.grO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bOI();
            }
        });
        this.gpQ.setVisibility(8);
        this.grO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        ao aoVar = new ao();
        aoVar.aLw = -1;
        aoVar.aLx = -1;
        aoVar.aLz = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    public void a(com.baidu.tieba.ala.data.e eVar) {
        String str;
        this.grR = eVar;
        this.gpQ.setVisibility(0);
        this.grO.setVisibility(0);
        if (!StringUtils.isNullObject(eVar.portrait)) {
            m.a(this.bmU, eVar.portrait, true, false);
        }
        if (!TextUtils.isEmpty(eVar.gUv)) {
            String str2 = eVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 10) {
                str2 = TextHelper.subStringWithEmoji(str2, 10) + StringHelper.STRING_MORE;
            }
            this.eKp.setText(str2 + eVar.gUv);
        } else {
            this.eKp.setText(eVar.userName);
        }
        if (eVar.gUw) {
            String format = String.format(getPageContext().getResources().getString(a.h.snatch_red_packet_amount_desc), Long.valueOf(eVar.gUd));
            this.grO.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpQ.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds184);
            this.gpQ.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.h.snatch_red_packet_failed_1);
            this.grO.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gpQ.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.gpQ.setLayoutParams(layoutParams2);
            str = string;
        }
        this.grN.setText(str);
        Q(eVar.gUx);
    }

    private void Q(ArrayList<e.a> arrayList) {
        this.grQ = new a(getPageContext().getPageActivity(), arrayList);
        this.grP.setAdapter((ListAdapter) this.grQ);
        this.grQ.notifyDataSetChanged();
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
            com.baidu.live.utils.i.ae(this.cFi);
            this.cFi.setScaleX(0.85f);
            this.cFi.setScaleY(0.85f);
            return;
        }
        com.baidu.live.utils.i.af(this.cFi);
        this.cFi.setScaleX(1.0f);
        this.cFi.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.grS != null) {
            this.grS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.axL);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends BaseAdapter {
        private ArrayList<e.a> grV;
        private Context mContext;

        public a(Context context, ArrayList<e.a> arrayList) {
            this.mContext = context;
            this.grV = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.grV != null) {
                return this.grV.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: to */
        public e.a getItem(int i) {
            if (this.grV != null) {
                return this.grV.get(i);
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
                bVar2.ccB = (HeadImageView) view.findViewById(a.f.rp_user_list_icon);
                bVar2.ccB.setIsRound(true);
                bVar2.ccB.setDefaultResource(a.e.sdk_icon_default_avatar100);
                bVar2.ccB.setAutoChangeStyle(true);
                bVar2.ccB.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.grW = (TextView) view.findViewById(a.f.rp_user_list_name);
                bVar2.grX = (TextView) view.findViewById(a.f.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    m.a(bVar.ccB, item.portrait, true, false);
                }
                bVar.grW.setText(item.userName);
                bVar.grX.setText(String.format(this.mContext.getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes10.dex */
    private static class b {
        public HeadImageView ccB;
        public TextView grW;
        public TextView grX;

        private b() {
        }
    }
}
