package com.baidu.tieba.ala.liveroom.recommend.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes4.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.ala.liveroom.recommend.data.a, C0589a> {
    private int cardWidth;
    private q fYm;
    private int gvI;

    public a(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    public void sq(int i) {
        this.gvI = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: aA */
    public C0589a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0589a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.recommend.data.a aVar, C0589a c0589a) {
        c0589a.a(aVar, i, this.gvI, this.fYm);
        return view;
    }

    public void e(q qVar) {
        this.fYm = qVar;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0589a extends TypeAdapter.ViewHolder {
        private q fYm;
        private int gvI;
        private RelativeLayout[] gvJ;
        private TbImageView[] gvK;
        private TextView[] gvL;
        private TextView[] gvM;
        private LinearLayout[] gvN;
        private TextView[] gvO;
        private com.baidu.tieba.ala.liveroom.recommend.data.a gvP;
        private String gvQ;
        private Context mContext;
        private int mPosition;

        private C0589a(View view, Context context, int i) {
            super(view);
            this.gvQ = "";
            this.mContext = context;
            this.gvJ = new RelativeLayout[2];
            this.gvK = new TbImageView[2];
            this.gvL = new TextView[2];
            this.gvM = new TextView[2];
            this.gvN = new LinearLayout[2];
            this.gvO = new TextView[2];
            this.gvJ[0] = (RelativeLayout) view.findViewById(a.g.left_content_layout);
            this.gvJ[1] = (RelativeLayout) view.findViewById(a.g.right_content_layout);
            this.gvK[0] = (TbImageView) view.findViewById(a.g.left_cover_imageView);
            this.gvK[1] = (TbImageView) view.findViewById(a.g.right_cover_imageView);
            this.gvL[0] = (TextView) view.findViewById(a.g.left_count_textView);
            this.gvL[1] = (TextView) view.findViewById(a.g.right_count_textView);
            this.gvM[0] = (TextView) view.findViewById(a.g.left_name_textView);
            this.gvM[1] = (TextView) view.findViewById(a.g.right_name_textView);
            this.gvN[0] = (LinearLayout) view.findViewById(a.g.left_location_layout);
            this.gvN[1] = (LinearLayout) view.findViewById(a.g.right_location_layout);
            this.gvO[0] = (TextView) view.findViewById(a.g.left_location_textView);
            this.gvO[1] = (TextView) view.findViewById(a.g.right_location_textView);
            this.gvK[0].getLayoutParams().width = i;
            this.gvK[0].getLayoutParams().height = i;
            this.gvK[1].getLayoutParams().width = i;
            this.gvK[1].getLayoutParams().height = i;
            this.gvK[0].setDefaultBgResource(a.f.sdk_shape_transparent);
            this.gvK[1].setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.gvQ = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.gvJ[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0589a.this.gvP != null) {
                        if (C0589a.this.gvP.gvV != null) {
                            C0589a.this.b(C0589a.this.gvP.gvV, 0, C0589a.this.gvP.type);
                        } else if (C0589a.this.gvP.gvW != null) {
                            C0589a.this.b(C0589a.this.gvP.gvW, 0, C0589a.this.gvP.type);
                        }
                    }
                }
            });
            this.gvJ[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0589a.this.gvP != null && C0589a.this.gvP.gvW != null) {
                        C0589a.this.b(C0589a.this.gvP.gvW, 1, C0589a.this.gvP.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.ala.liveroom.recommend.data.a aVar, int i, int i2, q qVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.gvP = aVar;
                this.mPosition = i;
                this.gvI = i2;
                this.fYm = qVar;
                if (aVar.gvV != null) {
                    a(aVar.gvV, 0, this.gvP.type);
                }
                if (aVar.gvW != null) {
                    if (aVar.gvV == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.gvW, i3, this.gvP.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.gvJ[1].setVisibility(0);
                } else {
                    this.gvJ[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.gvK[i].startLoad(alaRecommendLiveData.cover + this.gvQ, 10, false);
            this.gvM[i].setText(alaRecommendLiveData.getNameShow());
            this.gvL[i].setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.gvO[i].setText(alaRecommendLiveData.distance);
                this.gvN[i].setVisibility(0);
            } else {
                this.gvN[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                String str = "";
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext);
                alaLiveRoomActivityConfig.addExtraByLiveId(alaRecommendLiveData.live_id, String.valueOf(alaRecommendLiveData.room_id), AlaLiveRoomActivityConfig.FROM_TYPE_RECOMMEND_LIVE);
                try {
                    String flvUrl = alaRecommendLiveData.session_info != null ? alaRecommendLiveData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT) : "";
                    String str2 = alaRecommendLiveData.cover;
                    String valueOf = String.valueOf(alaRecommendLiveData.room_id);
                    String valueOf2 = String.valueOf(alaRecommendLiveData.live_id);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("live_url", flvUrl);
                    jSONObject.put("cover", str2);
                    jSONObject.put("enterRoomId", valueOf);
                    jSONObject.put("enterLiveId", valueOf2);
                    str = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                alaLiveRoomActivityConfig.addExtraByParams(str);
                if (this.fYm != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.fYm.ayC != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.fYm.ayC.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.fYm.ayC.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.fYm.ayC.nickName);
                    }
                    if (this.fYm.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.fYm.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.fYm.mLiveInfo.room_id);
                    }
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                a(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, alaRecommendLiveData, i2, i);
            }
        }

        private void a(String str, String str2, AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            int i3;
            if (alaRecommendLiveData != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (i == 0) {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        } else if (this.gvI > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.gvI / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "your_recommend", null).setContentExt(jSONObject));
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }
}
