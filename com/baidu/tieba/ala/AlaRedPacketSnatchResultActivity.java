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
/* loaded from: classes11.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView blt;
    private String buH;
    private FrameLayout cDI;
    private TextView eIO;
    private View gog;
    private LinearLayout goh;
    private TextView gqd;
    private TextView gqe;
    private TextView gqf;
    private BdListView gqg;
    private a gqh;
    private com.baidu.tieba.ala.data.e gqi;
    private com.baidu.tieba.ala.g.g gqj;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private CustomMessageListener awl = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private o gqk = new o() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
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
            this.gqj = new com.baidu.tieba.ala.g.g(getPageContext(), this.gqk);
            this.gqj.ay(this.mRedPacketId, this.mLiveId, this.buH);
            MessageManager.getInstance().registerListener(this.awl);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.buH = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.gog = findViewById(a.f.rp_result_root_bg);
        this.gog.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.cDI = (FrameLayout) findViewById(a.f.rp_result_root_container);
        this.blt = (HeadImageView) findViewById(a.f.rp_result_user_icon);
        this.blt.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.blt.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.blt.setIsRound(true);
        this.blt.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.blt.setAutoChangeStyle(true);
        this.blt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gqd = (TextView) findViewById(a.f.p_result_top10_desc);
        this.eIO = (TextView) findViewById(a.f.p_result_user_name);
        this.gqe = (TextView) findViewById(a.f.p_result_loot_amount);
        this.goh = (LinearLayout) findViewById(a.f.rp_result_content);
        this.gqf = (TextView) findViewById(a.f.p_result_send_gift);
        this.gqg = (BdListView) findViewById(a.f.p_result_listview);
        this.gqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bOC();
            }
        });
        this.goh.setVisibility(8);
        this.gqf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOC() {
        ao aoVar = new ao();
        aoVar.aJW = -1;
        aoVar.aJX = -1;
        aoVar.aJZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    public void a(com.baidu.tieba.ala.data.e eVar) {
        String str;
        this.gqi = eVar;
        this.goh.setVisibility(0);
        this.gqf.setVisibility(0);
        if (!StringUtils.isNullObject(eVar.portrait)) {
            m.a(this.blt, eVar.portrait, true, false);
        }
        if (!TextUtils.isEmpty(eVar.gSM)) {
            String str2 = eVar.userName;
            if (TextHelper.getTextLengthWithEmoji(str2) > 10) {
                str2 = TextHelper.subStringWithEmoji(str2, 10) + StringHelper.STRING_MORE;
            }
            this.eIO.setText(str2 + eVar.gSM);
        } else {
            this.eIO.setText(eVar.userName);
        }
        if (eVar.gSN) {
            String format = String.format(getPageContext().getResources().getString(a.h.snatch_red_packet_amount_desc), Long.valueOf(eVar.gSu));
            this.gqf.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.goh.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds184);
            this.goh.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.h.snatch_red_packet_failed_1);
            this.gqf.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.goh.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.goh.setLayoutParams(layoutParams2);
            str = string;
        }
        this.gqe.setText(str);
        Q(eVar.gSO);
    }

    private void Q(ArrayList<e.a> arrayList) {
        this.gqh = new a(getPageContext().getPageActivity(), arrayList);
        this.gqg.setAdapter((ListAdapter) this.gqh);
        this.gqh.notifyDataSetChanged();
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
            com.baidu.live.utils.i.ae(this.cDI);
            this.cDI.setScaleX(0.85f);
            this.cDI.setScaleY(0.85f);
            return;
        }
        com.baidu.live.utils.i.af(this.cDI);
        this.cDI.setScaleX(1.0f);
        this.cDI.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gqj != null) {
            this.gqj.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.awl);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends BaseAdapter {
        private ArrayList<e.a> gqm;
        private Context mContext;

        public a(Context context, ArrayList<e.a> arrayList) {
            this.mContext = context;
            this.gqm = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.gqm != null) {
                return this.gqm.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: tm */
        public e.a getItem(int i) {
            if (this.gqm != null) {
                return this.gqm.get(i);
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
                bVar2.caZ = (HeadImageView) view.findViewById(a.f.rp_user_list_icon);
                bVar2.caZ.setIsRound(true);
                bVar2.caZ.setDefaultResource(a.e.sdk_icon_default_avatar100);
                bVar2.caZ.setAutoChangeStyle(true);
                bVar2.caZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.gqn = (TextView) view.findViewById(a.f.rp_user_list_name);
                bVar2.gqo = (TextView) view.findViewById(a.f.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    m.a(bVar.caZ, item.portrait, true, false);
                }
                bVar.gqn.setText(item.userName);
                bVar.gqo.setText(String.format(this.mContext.getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes11.dex */
    private static class b {
        public HeadImageView caZ;
        public TextView gqn;
        public TextView gqo;

        private b() {
        }
    }
}
