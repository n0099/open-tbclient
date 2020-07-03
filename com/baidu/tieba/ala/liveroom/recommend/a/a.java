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
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.liveroom.recommend.data.AlaRecommendLiveData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends AbsDelegateAdapter<AlaRecommendLiveData, C0579a> {
    private q fST;
    private int gqB;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void rY(int i) {
        this.gqB = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: az */
    public C0579a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0579a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, AlaRecommendLiveData alaRecommendLiveData, C0579a c0579a) {
        c0579a.a(alaRecommendLiveData, i, this.gqB, this.fST);
        return view;
    }

    public void e(q qVar) {
        this.fST = qVar;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.recommend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0579a extends TypeAdapter.ViewHolder {
        private q fST;
        private int gqB;
        private TbImageView gqC;
        private TextView gqD;
        private TextView gqE;
        private AlaRecommendLiveData gqF;
        private Context mContext;
        private int mPosition;
        private String mPrefix;

        private C0579a(View view, Context context) {
            super(view);
            this.mContext = context;
            this.gqC = (TbImageView) view.findViewById(a.g.ala_recommend_live_bg);
            this.gqD = (TextView) view.findViewById(a.g.ala_recommend_live_name);
            this.gqE = (TextView) view.findViewById(a.g.ala_recommend_live_time);
            this.mPrefix = this.mContext.getResources().getString(a.i.recommend_live_start_until_now);
            this.gqC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.a.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    String str;
                    if (C0579a.this.gqF != null) {
                        String str2 = "";
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(C0579a.this.mContext);
                        alaLiveRoomActivityConfig.addExtraByLiveId(C0579a.this.gqF.live_id, String.valueOf(C0579a.this.gqF.room_id), AlaLiveRoomActivityConfig.FROM_TYPE_RECOMMEND_LIVE);
                        try {
                            if (C0579a.this.gqF.session_info != null) {
                                str = C0579a.this.gqF.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
                            } else {
                                str = "";
                            }
                            String str3 = C0579a.this.gqF.cover;
                            String valueOf = String.valueOf(C0579a.this.gqF.room_id);
                            String valueOf2 = String.valueOf(C0579a.this.gqF.live_id);
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
                        if (C0579a.this.fST != null) {
                            AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                            if (C0579a.this.fST.axp != null) {
                                alaLastLiveroomInfo.setLastAnchorPortrait(C0579a.this.fST.axp.portrait);
                                alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(C0579a.this.fST.axp.userId));
                                alaLastLiveroomInfo.setLastAnchorUname(C0579a.this.fST.axp.nickName);
                            }
                            if (C0579a.this.fST.mLiveInfo != null) {
                                alaLastLiveroomInfo.setLastLiveId(C0579a.this.fST.mLiveInfo.live_id);
                                alaLastLiveroomInfo.setLastRoomId(C0579a.this.fST.mLiveInfo.room_id);
                            }
                            alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                            alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                        C0579a.this.D(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK);
                    }
                }
            });
        }

        public void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2, q qVar) {
            if (alaRecommendLiveData != null) {
                this.gqF = alaRecommendLiveData;
                this.mPosition = i;
                this.gqB = i2;
                this.fST = qVar;
                this.gqC.startLoad(alaRecommendLiveData.cover, 10, false);
                if (alaRecommendLiveData.type == 0) {
                    this.gqD.setText(alaRecommendLiveData.getNameShow());
                    long abs = Math.abs(System.currentTimeMillis() - (alaRecommendLiveData.start_time * 1000));
                    int i3 = (int) (((float) abs) / 3600000.0f);
                    int i4 = (int) (((float) (abs % BdKVCache.MILLS_1Hour)) / 60000.0f);
                    StringBuilder sb = new StringBuilder(this.mPrefix);
                    if (i3 > 0) {
                        sb.append(String.format(this.mContext.getResources().getString(a.i.recommend_live_start_until_now_hour), String.valueOf(i3)));
                    }
                    if (i4 > 0) {
                        sb.append(String.format(this.mContext.getResources().getString(a.i.recommend_live_start_until_now_minute), String.valueOf(i4)));
                    }
                    this.gqE.setText(sb.toString());
                } else {
                    this.gqD.setText(alaRecommendLiveData.getLiveTitle());
                    if (!TextUtils.isEmpty(alaRecommendLiveData.distance)) {
                        this.gqE.setText(alaRecommendLiveData.distance);
                    } else {
                        this.gqE.setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                    }
                }
                D(UbcStatisticLiveKey.KEY_ID_1392, "show");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D(String str, String str2) {
            int i;
            try {
                if (this.gqF != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject put = jSONObject.put("live_id", this.gqF.live_id).put("vid", this.gqF.feed_id).put("model", this.gqF.type == 0 ? "yourfollower" : "hotlive");
                        if (this.gqF.type == 0) {
                            i = this.mPosition + 1;
                        } else {
                            i = this.gqB > 0 ? (this.mPosition - this.gqB) - 1 : this.mPosition;
                        }
                        put.put("pos", i).put("nearby", (this.gqF.type != 1 || TextUtils.isEmpty(this.gqF.distance)) ? "0" : "1");
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
