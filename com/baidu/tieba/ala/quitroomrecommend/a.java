package com.baidu.tieba.ala.quitroomrecommend;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.quitroomrecommend.data.AlaQuitRoomRecommendData;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private int cardWidth;
    private Context mContext;
    private List<com.baidu.tieba.ala.quitroomrecommend.data.a> mDatas;
    private int mScreenWidth;

    public a(Context context) {
        this.mContext = context;
        this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
        cnH();
    }

    public void setData(List<com.baidu.tieba.ala.quitroomrecommend.data.a> list) {
        this.mDatas = list;
        notifyDataSetChanged();
    }

    private void cnH() {
        this.cardWidth = (((this.mScreenWidth - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds34)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds34)) - this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16)) / 2;
        if (this.cardWidth <= 0) {
            this.cardWidth = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds372);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDatas == null) {
            return 0;
        }
        return this.mDatas.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mDatas.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0693a c0693a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_recommend_live_item_layout, viewGroup, false);
            C0693a c0693a2 = new C0693a(view, this.mContext, this.cardWidth);
            view.setTag(c0693a2);
            c0693a = c0693a2;
        } else {
            c0693a = (C0693a) view.getTag();
        }
        c0693a.a(this.mDatas.get(i), i);
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.quitroomrecommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0693a {
        private LinearLayout[] ibA;
        private TextView[] ibB;
        private TbImageView[] ibC;
        private ViewGroup[] ibD;
        private TextView[] ibE;
        private com.baidu.tieba.ala.quitroomrecommend.data.a ibF;
        private String ibG;
        private RelativeLayout[] ibw;
        private TbImageView[] ibx;
        private TextView[] iby;
        private TextView[] ibz;
        private Context mContext;
        private int mPosition;

        private C0693a(View view, Context context, int i) {
            this.ibG = "";
            this.mContext = context;
            this.ibw = new RelativeLayout[2];
            this.ibx = new TbImageView[2];
            this.iby = new TextView[2];
            this.ibz = new TextView[2];
            this.ibA = new LinearLayout[2];
            this.ibB = new TextView[2];
            this.ibE = new TextView[2];
            this.ibC = new TbImageView[2];
            this.ibD = new ViewGroup[2];
            this.ibE[0] = (TextView) view.findViewById(a.f.sdk_ala_left_tv_label);
            this.ibE[1] = (TextView) view.findViewById(a.f.sdk_ala_right_tv_label);
            this.ibC[0] = (TbImageView) view.findViewById(a.f.sdk_ala_left_iv_icon);
            this.ibC[1] = (TbImageView) view.findViewById(a.f.sdk_ala_right_iv_icon);
            this.ibD[0] = (ViewGroup) view.findViewById(a.f.sdk_ala_left_quit_item_icon_container);
            this.ibD[1] = (ViewGroup) view.findViewById(a.f.sdk_ala_right_quit_item_icon_container);
            this.ibw[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.ibw[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.ibx[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ibx[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.iby[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.iby[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ibz[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ibz[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.ibA[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.ibA[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ibB[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ibB[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.ibw[0].getLayoutParams().width = i;
            this.ibw[0].getLayoutParams().height = i;
            this.ibw[1].getLayoutParams().width = i;
            this.ibw[1].getLayoutParams().height = i;
            this.ibx[0].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.ibx[0].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.ibx[1].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.ibx[1].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.ibC[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ibC[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.ibG = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.ibw[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0693a.this.ibF != null) {
                        if (C0693a.this.ibF.ibW != null) {
                            C0693a.this.a(C0693a.this.ibF.ibW);
                        } else if (C0693a.this.ibF.ibX != null) {
                            C0693a.this.a(C0693a.this.ibF.ibX);
                        }
                    }
                }
            });
            this.ibw[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0693a.this.ibF != null && C0693a.this.ibF.ibX != null) {
                        C0693a.this.a(C0693a.this.ibF.ibX);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.ala.quitroomrecommend.data.a aVar, int i) {
            boolean z;
            int i2;
            if (aVar != null) {
                this.ibF = aVar;
                this.mPosition = i;
                if (aVar.ibW != null) {
                    a(aVar.ibW, 0);
                }
                if (aVar.ibX != null) {
                    if (aVar.ibW == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(aVar.ibX, i2);
                } else {
                    z = false;
                }
                if (z) {
                    this.ibw[1].setVisibility(0);
                } else {
                    this.ibw[1].setVisibility(8);
                }
            }
        }

        private void a(AlaQuitRoomRecommendData alaQuitRoomRecommendData, int i) {
            String str = alaQuitRoomRecommendData.cover + this.ibG;
            if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon) && TextUtils.isEmpty(alaQuitRoomRecommendData.labelText)) {
                this.ibD[i].setVisibility(4);
            } else {
                this.ibD[i].setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ibE[i].getLayoutParams();
                if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon)) {
                    layoutParams.leftMargin = 0;
                    this.ibC[i].setVisibility(8);
                } else {
                    this.ibC[i].startLoad(alaQuitRoomRecommendData.labelIcon, 10, false);
                    this.ibC[i].setVisibility(0);
                    layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds4);
                }
                this.ibE[i].setText(alaQuitRoomRecommendData.labelText);
                this.ibE[i].setLayoutParams(layoutParams);
            }
            this.ibx[i].startLoad(str, 10, false);
            this.ibz[i].setText(alaQuitRoomRecommendData.getNameShow());
            this.iby[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaQuitRoomRecommendData.audience_count)));
            if (!TextUtils.isEmpty(alaQuitRoomRecommendData.distance) && !TextUtils.equals(alaQuitRoomRecommendData.distance, "0")) {
                this.ibB[i].setText(alaQuitRoomRecommendData.distance);
                this.ibA[i].setVisibility(0);
                return;
            }
            this.ibA[i].setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AlaQuitRoomRecommendData alaQuitRoomRecommendData) {
            if (alaQuitRoomRecommendData != null) {
                com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(alaQuitRoomRecommendData.live_id)));
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("author_uid", alaQuitRoomRecommendData.user_id);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, "liveroom", "").setContentExt(null, "quit_reco", jSONObject));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String str = "";
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext);
                alaLiveRoomActivityConfig.addExtraByLiveId(alaQuitRoomRecommendData.live_id, String.valueOf(alaQuitRoomRecommendData.room_id), AlaLiveRoomActivityConfig.FROM_TYPE_QUIT_ROOM_RECOMMEND_LIVE);
                try {
                    String flvUrl = alaQuitRoomRecommendData.session_info != null ? alaQuitRoomRecommendData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT) : "";
                    String str2 = alaQuitRoomRecommendData.cover;
                    String valueOf = String.valueOf(alaQuitRoomRecommendData.room_id);
                    String valueOf2 = String.valueOf(alaQuitRoomRecommendData.live_id);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("live_url", flvUrl);
                    jSONObject2.put("cover", str2);
                    jSONObject2.put("enterRoomId", valueOf);
                    jSONObject2.put("enterLiveId", valueOf2);
                    str = jSONObject2.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                alaLiveRoomActivityConfig.addExtraByParams(str);
                com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
            }
        }
    }
}
