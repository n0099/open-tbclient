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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private int cardWidth;
    private Context mContext;
    private List<com.baidu.tieba.ala.quitroomrecommend.data.a> mDatas;
    private int mScreenWidth;

    public a(Context context) {
        this.mContext = context;
        this.mScreenWidth = BdUtilHelper.getEquipmentWidth(this.mContext);
        coF();
    }

    public void setData(List<com.baidu.tieba.ala.quitroomrecommend.data.a> list) {
        this.mDatas = list;
        notifyDataSetChanged();
    }

    private void coF() {
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
    /* loaded from: classes11.dex */
    public static class C0693a {
        private RelativeLayout[] ifU;
        private TbImageView[] ifV;
        private TextView[] ifW;
        private TextView[] ifX;
        private LinearLayout[] ifY;
        private TextView[] ifZ;
        private TbImageView[] iga;
        private ViewGroup[] igb;
        private TextView[] igc;
        private com.baidu.tieba.ala.quitroomrecommend.data.a igd;
        private String ige;
        private Context mContext;
        private int mPosition;

        private C0693a(View view, Context context, int i) {
            this.ige = "";
            this.mContext = context;
            this.ifU = new RelativeLayout[2];
            this.ifV = new TbImageView[2];
            this.ifW = new TextView[2];
            this.ifX = new TextView[2];
            this.ifY = new LinearLayout[2];
            this.ifZ = new TextView[2];
            this.igc = new TextView[2];
            this.iga = new TbImageView[2];
            this.igb = new ViewGroup[2];
            this.igc[0] = (TextView) view.findViewById(a.f.sdk_ala_left_tv_label);
            this.igc[1] = (TextView) view.findViewById(a.f.sdk_ala_right_tv_label);
            this.iga[0] = (TbImageView) view.findViewById(a.f.sdk_ala_left_iv_icon);
            this.iga[1] = (TbImageView) view.findViewById(a.f.sdk_ala_right_iv_icon);
            this.igb[0] = (ViewGroup) view.findViewById(a.f.sdk_ala_left_quit_item_icon_container);
            this.igb[1] = (ViewGroup) view.findViewById(a.f.sdk_ala_right_quit_item_icon_container);
            this.ifU[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.ifU[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.ifV[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ifV[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.ifW[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.ifW[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ifX[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ifX[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.ifY[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.ifY[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ifZ[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ifZ[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.ifU[0].getLayoutParams().width = i;
            this.ifU[0].getLayoutParams().height = i;
            this.ifU[1].getLayoutParams().width = i;
            this.ifU[1].getLayoutParams().height = i;
            this.ifV[0].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.ifV[0].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.ifV[1].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.ifV[1].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.iga[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.iga[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.ige = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.ifU[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0693a.this.igd != null) {
                        if (C0693a.this.igd.igu != null) {
                            C0693a.this.a(C0693a.this.igd.igu);
                        } else if (C0693a.this.igd.igv != null) {
                            C0693a.this.a(C0693a.this.igd.igv);
                        }
                    }
                }
            });
            this.ifU[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0693a.this.igd != null && C0693a.this.igd.igv != null) {
                        C0693a.this.a(C0693a.this.igd.igv);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.ala.quitroomrecommend.data.a aVar, int i) {
            boolean z;
            int i2;
            if (aVar != null) {
                this.igd = aVar;
                this.mPosition = i;
                if (aVar.igu != null) {
                    a(aVar.igu, 0);
                }
                if (aVar.igv != null) {
                    if (aVar.igu == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(aVar.igv, i2);
                } else {
                    z = false;
                }
                if (z) {
                    this.ifU[1].setVisibility(0);
                } else {
                    this.ifU[1].setVisibility(8);
                }
            }
        }

        private void a(AlaQuitRoomRecommendData alaQuitRoomRecommendData, int i) {
            String str = alaQuitRoomRecommendData.cover + this.ige;
            if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon) && TextUtils.isEmpty(alaQuitRoomRecommendData.labelText)) {
                this.igb[i].setVisibility(4);
            } else {
                this.igb[i].setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.igc[i].getLayoutParams();
                if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon)) {
                    layoutParams.leftMargin = 0;
                    this.iga[i].setVisibility(8);
                } else {
                    this.iga[i].startLoad(alaQuitRoomRecommendData.labelIcon, 10, false);
                    this.iga[i].setVisibility(0);
                    layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds4);
                }
                this.igc[i].setText(alaQuitRoomRecommendData.labelText);
                this.igc[i].setLayoutParams(layoutParams);
            }
            this.ifV[i].startLoad(str, 10, false);
            this.ifX[i].setText(alaQuitRoomRecommendData.getNameShow());
            this.ifW[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaQuitRoomRecommendData.audience_count)));
            if (!TextUtils.isEmpty(alaQuitRoomRecommendData.distance) && !TextUtils.equals(alaQuitRoomRecommendData.distance, "0")) {
                this.ifZ[i].setText(alaQuitRoomRecommendData.distance);
                this.ifY[i].setVisibility(0);
                return;
            }
            this.ifY[i].setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AlaQuitRoomRecommendData alaQuitRoomRecommendData) {
            if (alaQuitRoomRecommendData != null) {
                com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(alaQuitRoomRecommendData.live_id)));
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
                com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
            }
        }
    }
}
