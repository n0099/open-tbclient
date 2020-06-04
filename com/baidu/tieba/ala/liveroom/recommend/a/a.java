package com.baidu.tieba.ala.liveroom.recommend.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.recommend.data.AlaRecommendLiveData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends AbsDelegateAdapter<AlaRecommendLiveData, C0570a> {
    private int gdH;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void rA(int i) {
        this.gdH = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: aw */
    public C0570a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0570a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, AlaRecommendLiveData alaRecommendLiveData, C0570a c0570a) {
        c0570a.a(alaRecommendLiveData, i, this.gdH);
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0570a extends TypeAdapter.ViewHolder {
        private int gdH;
        private TbImageView gdI;
        private TextView gdJ;
        private TextView gdK;
        private AlaRecommendLiveData gdL;
        private Context mContext;
        private int mPosition;
        private String mPrefix;

        private C0570a(View view, Context context) {
            super(view);
            this.mContext = context;
            this.gdI = (TbImageView) view.findViewById(a.g.ala_recommend_live_bg);
            this.gdJ = (TextView) view.findViewById(a.g.ala_recommend_live_name);
            this.gdK = (TextView) view.findViewById(a.g.ala_recommend_live_time);
            this.mPrefix = this.mContext.getResources().getString(a.i.recommend_live_start_until_now);
            this.gdI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    if (C0570a.this.gdL != null) {
                        String str2 = "";
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(C0570a.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(C0570a.this.gdL.live_id, String.valueOf(C0570a.this.gdL.room_id), AlaLiveRoomActivityConfig.FROM_TYPE_RECOMMEND_LIVE);
                        try {
                            if (C0570a.this.gdL.session_info != null) {
                                str = C0570a.this.gdL.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                            } else {
                                str = "";
                            }
                            String str3 = C0570a.this.gdL.cover;
                            String valueOf = String.valueOf(C0570a.this.gdL.room_id);
                            String valueOf2 = String.valueOf(C0570a.this.gdL.live_id);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("live_url", str);
                            jSONObject.put("cover", str3);
                            jSONObject.put("enterRoomId", valueOf);
                            jSONObject.put("enterLiveId", valueOf2);
                            str2 = jSONObject.toString();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        alaLiveRoomActivityConfig.addExtraByParams(str2);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                        C0570a.this.D(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK);
                    }
                }
            });
        }

        public void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                this.gdL = alaRecommendLiveData;
                this.mPosition = i;
                this.gdH = i2;
                this.gdI.startLoad(alaRecommendLiveData.cover, 10, false);
                if (alaRecommendLiveData.type == 0) {
                    this.gdJ.setText(alaRecommendLiveData.getNameShow());
                    long abs = Math.abs(System.currentTimeMillis() - (alaRecommendLiveData.start_time * 1000));
                    int ceil = (int) Math.ceil(((float) abs) / 3600000.0f);
                    int ceil2 = (int) Math.ceil(((float) (abs % BdKVCache.MILLS_1Hour)) / 60000.0f);
                    StringBuilder sb = new StringBuilder(this.mPrefix);
                    if (ceil > 0) {
                        sb.append(String.format(this.mContext.getResources().getString(a.i.recommend_live_start_until_now_hour), String.valueOf(ceil)));
                    }
                    if (ceil2 > 0) {
                        sb.append(String.format(this.mContext.getResources().getString(a.i.recommend_live_start_until_now_minute), String.valueOf(ceil2)));
                    }
                    this.gdK.setText(sb.toString());
                } else {
                    this.gdJ.setText(alaRecommendLiveData.getLiveTitle());
                    if (!TextUtils.isEmpty(alaRecommendLiveData.distance)) {
                        this.gdK.setText(alaRecommendLiveData.distance);
                    } else {
                        this.gdK.setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                    }
                }
                D(UbcStatisticLiveKey.KEY_ID_1392, "show");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D(String str, String str2) {
            int i;
            try {
                if (this.gdL != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject put = jSONObject.put("live_id", this.gdL.live_id).put("vid", this.gdL.feed_id).put("model", this.gdL.type == 0 ? "yourfollower" : "hotlive");
                        if (this.gdL.type == 0) {
                            i = this.mPosition + 1;
                        } else {
                            i = this.gdH > 0 ? (this.mPosition - this.gdH) - 1 : this.mPosition;
                        }
                        put.put("pos", i).put("nearby", (this.gdL.type != 1 || TextUtils.isEmpty(this.gdL.distance)) ? "0" : "1");
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "your_recommend", null).setContentExt(jSONObject));
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}
