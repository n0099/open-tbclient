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
import com.baidu.live.ao.c;
import com.baidu.live.data.w;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
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
    private w bur;
    private ArrayList<g> eOt;
    public RelativeLayout gTP;
    private TextView gUb;
    private b gUc;
    private TextView gUd;
    private HeadImageView gUe;
    private TextView gUf;
    private TextView gUg;
    public Button gUh;
    public long gUi;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eOt = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOt = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.gUd = (TextView) this.mView.findViewById(a.f.get_view_now_score);
        this.gTP = (RelativeLayout) this.mView.findViewById(a.f.get_view_root_container);
        this.gUh = (Button) this.mView.findViewById(a.f.get_view_horizontal_close_button);
        this.gUh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.gUe = (HeadImageView) this.mView.findViewById(a.f.get_view_live_head);
        this.gUe.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gUe.setIsRound(true);
        this.gUe.setAutoChangeStyle(false);
        this.gUf = (TextView) this.mView.findViewById(a.f.get_view_live_name);
        this.gUc = new b(getContext());
        this.gUb = (TextView) this.mView.findViewById(a.f.get_headline_button);
        this.gUb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.bur.aKt.aJk) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.h.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eOt.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eOt.get(AlaGetHeadlineView.this.gUc.bXx());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.Ha())) {
                            AlaGetHeadlineView.this.h((g) AlaGetHeadlineView.this.eOt.get(AlaGetHeadlineView.this.gUc.bXx()));
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
        this.mListView = (BdListView) this.mView.findViewById(a.f.get_view_gift_list);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaGetHeadlineView.this.gUc.vT(i);
                AlaGetHeadlineView.this.gUc.notifyDataSetChanged();
            }
        });
        this.gUg = (TextView) this.mView.findViewById(a.f.get_view_get_headline_support);
        this.gUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.bur.aKt.aJu;
                cVar.bRy = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.gUc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g gVar) {
        ac.a(gVar, Long.parseLong(gVar.Ha()), this.bur.aJV.userId + "", this.bur.aJV.userName, this.bur.mLiveInfo.live_id + "", this.bur.mLiveInfo.room_id + "", this.bur.mLiveInfo.appId + "", this.bur.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        this.bur = wVar;
        this.eOt.clear();
        setData2View(wVar);
    }

    private void setData2View(w wVar) {
        if (this.gUi > 0 && wVar.aKt.aJl > 0 && wVar.aKt.aJn > wVar.aKt.aJl) {
            this.gUd.setText(com.baidu.tieba.ala.headline.a.fm(wVar.aKt.aJn));
            A(wVar.aKt.aJn);
        } else {
            this.gUd.setText(com.baidu.tieba.ala.headline.a.fm(wVar.aKt.aJl));
            A(wVar.aKt.aJl);
            this.gUc.bXy();
        }
        this.gUe.startLoad(wVar.aJV.portrait, 12, false, false);
        this.gUf.setText(wVar.aJV.nickName);
    }

    private void A(double d) {
        String Iw = ac.Iw();
        if (Iw != null && Iw.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(Iw), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.KG().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().HA()) {
                    if (gVar.aVY) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.gV(ceil + "");
                        this.eOt.add(gVar);
                    }
                }
            }
            ae(this.eOt);
            this.gUc.a(this.eOt, d);
        }
    }

    private void ae(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.Ha()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.Ha()) * Long.parseLong(gVar2.getPrice()));
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
