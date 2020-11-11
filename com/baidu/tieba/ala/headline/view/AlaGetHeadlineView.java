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
import com.baidu.live.ak.c;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
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
    private w bqS;
    private ArrayList<g> eIM;
    public RelativeLayout gKW;
    private TextView gLh;
    private b gLi;
    private TextView gLj;
    private HeadImageView gLk;
    private TextView gLl;
    private TextView gLm;
    public Button gLn;
    public long gLo;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eIM = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eIM = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.gLj = (TextView) this.mView.findViewById(a.f.get_view_now_score);
        this.gKW = (RelativeLayout) this.mView.findViewById(a.f.get_view_root_container);
        this.gLn = (Button) this.mView.findViewById(a.f.get_view_horizontal_close_button);
        this.gLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.gLk = (HeadImageView) this.mView.findViewById(a.f.get_view_live_head);
        this.gLk.setDefaultBgResource(a.e.sdk_default_avatar);
        this.gLk.setIsRound(true);
        this.gLk.setAutoChangeStyle(false);
        this.gLl = (TextView) this.mView.findViewById(a.f.get_view_live_name);
        this.gLi = new b(getContext());
        this.gLh = (TextView) this.mView.findViewById(a.f.get_headline_button);
        this.gLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.bqS.aJt.aIl) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.h.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eIM.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eIM.get(AlaGetHeadlineView.this.gLi.bUv());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.FW())) {
                            AlaGetHeadlineView.this.g((g) AlaGetHeadlineView.this.eIM.get(AlaGetHeadlineView.this.gLi.bUv()));
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
                AlaGetHeadlineView.this.gLi.uO(i);
                AlaGetHeadlineView.this.gLi.notifyDataSetChanged();
            }
        });
        this.gLm = (TextView) this.mView.findViewById(a.f.get_view_get_headline_support);
        this.gLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.bqS.aJt.aIv;
                cVar.bOc = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.gLi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        aa.b(gVar, Long.parseLong(gVar.FW()), this.bqS.aIV.userId + "", this.bqS.aIV.userName, this.bqS.mLiveInfo.live_id + "", this.bqS.mLiveInfo.room_id + "", this.bqS.mLiveInfo.appId + "", this.bqS.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(w wVar, String str) {
        this.otherParams = str;
        this.bqS = wVar;
        this.eIM.clear();
        setData2View(wVar);
    }

    private void setData2View(w wVar) {
        if (this.gLo > 0 && wVar.aJt.aIm > 0 && wVar.aJt.aIo > wVar.aJt.aIm) {
            this.gLj.setText(com.baidu.tieba.ala.headline.a.eI(wVar.aJt.aIo));
            A(wVar.aJt.aIo);
        } else {
            this.gLj.setText(com.baidu.tieba.ala.headline.a.eI(wVar.aJt.aIm));
            A(wVar.aJt.aIm);
            this.gLi.bUw();
        }
        this.gLk.startLoad(wVar.aIV.portrait, 12, false, false);
        this.gLl.setText(wVar.aIV.nickName);
    }

    private void A(double d) {
        String Ho = aa.Ho();
        if (Ho != null && Ho.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.a(new JSONObject(Ho), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.Jp().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().Gu()) {
                    if (gVar.aUH) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.gG(ceil + "");
                        this.eIM.add(gVar);
                    }
                }
            }
            ad(this.eIM);
            this.gLi.a(this.eIM, d);
        }
    }

    private void ad(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.FW()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.FW()) * Long.parseLong(gVar2.getPrice()));
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
