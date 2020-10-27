package com.baidu.tieba.ala.headline.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.ai.c;
import com.baidu.live.data.w;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetHeadlineView extends RelativeLayout {
    private w bpz;
    private ArrayList<g> eCX;
    private TextView gFA;
    public Button gFB;
    public long gFC;
    public RelativeLayout gFk;
    private TextView gFv;
    private b gFw;
    private TextView gFx;
    private HeadImageView gFy;
    private TextView gFz;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eCX = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eCX = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.h.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.gFx = (TextView) this.mView.findViewById(a.g.get_view_now_score);
        this.gFk = (RelativeLayout) this.mView.findViewById(a.g.get_view_root_container);
        this.gFB = (Button) this.mView.findViewById(a.g.get_view_horizontal_close_button);
        this.gFB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.gFy = (HeadImageView) this.mView.findViewById(a.g.get_view_live_head);
        this.gFy.setDefaultBgResource(a.f.sdk_default_avatar);
        this.gFy.setIsRound(true);
        this.gFy.setAutoChangeStyle(false);
        this.gFz = (TextView) this.mView.findViewById(a.g.get_view_live_name);
        this.gFw = new b(getContext());
        this.gFv = (TextView) this.mView.findViewById(a.g.get_headline_button);
        this.gFv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.bpz.aIC.aHt) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.i.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eCX.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eCX.get(AlaGetHeadlineView.this.gFw.bRW());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.Fv())) {
                            AlaGetHeadlineView.this.f((g) AlaGetHeadlineView.this.eCX.get(AlaGetHeadlineView.this.gFw.bRW()));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaGetHeadlineView.this.mContext, 0L, AlaGetHeadlineView.this.otherParams, true, "", true)));
                        return;
                    } else {
                        return;
                    }
                }
                ViewHelper.skipToLoginActivity(AlaGetHeadlineView.this.mContext);
            }
        });
        this.mListView = (BdListView) this.mView.findViewById(a.g.get_view_gift_list);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaGetHeadlineView.this.gFw.uE(i);
                AlaGetHeadlineView.this.gFw.notifyDataSetChanged();
            }
        });
        this.gFA = (TextView) this.mView.findViewById(a.g.get_view_get_headline_support);
        this.gFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.bpz.aIC.aHE;
                cVar.bIw = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.gFw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(g gVar) {
        ab.b(gVar, Long.parseLong(gVar.Fv()), this.bpz.aIe.userId + "", this.bpz.aIe.userName, this.bpz.mLiveInfo.live_id + "", this.bpz.mLiveInfo.room_id + "", this.bpz.mLiveInfo.appId + "", this.bpz.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        this.bpz = wVar;
        this.eCX.clear();
        setData2View(wVar);
    }

    private void setData2View(w wVar) {
        if (this.gFC > 0 && wVar.aIC.aHu > 0 && wVar.aIC.aHw > wVar.aIC.aHu) {
            this.gFx.setText(com.baidu.tieba.ala.headline.a.em(wVar.aIC.aHw));
            A(wVar.aIC.aHw);
        } else {
            this.gFx.setText(com.baidu.tieba.ala.headline.a.em(wVar.aIC.aHu));
            A(wVar.aIC.aHu);
            this.gFw.bRX();
        }
        this.gFy.startLoad(wVar.aIe.portrait, 12, false, false);
        this.gFz.setText(wVar.aIe.nickName);
    }

    private void A(double d) {
        String GN = ab.GN();
        if (GN != null && GN.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(GN), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<i> it = alaSdkGetGiftListHttpResponseMessage.IO().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().FT()) {
                    if (gVar.aTo) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.gB(ceil + "");
                        this.eCX.add(gVar);
                    }
                }
            }
            ad(this.eCX);
            this.gFw.a(this.eCX, d);
        }
    }

    private void ad(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.Fv()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.Fv()) * Long.parseLong(gVar2.getPrice()));
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
