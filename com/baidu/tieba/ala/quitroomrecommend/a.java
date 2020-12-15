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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes4.dex */
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
        C0718a c0718a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_recommend_live_item_layout, viewGroup, false);
            C0718a c0718a2 = new C0718a(view, this.mContext, this.cardWidth);
            view.setTag(c0718a2);
            c0718a = c0718a2;
        } else {
            c0718a = (C0718a) view.getTag();
        }
        c0718a.a(this.mDatas.get(i), i);
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.quitroomrecommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0718a {
        private RelativeLayout[] hTH;
        private TbImageView[] hTI;
        private TextView[] hTJ;
        private TextView[] hTK;
        private LinearLayout[] hTL;
        private TextView[] hTM;
        private TbImageView[] hTN;
        private ViewGroup[] hTO;
        private TextView[] hTP;
        private com.baidu.tieba.ala.quitroomrecommend.data.a hTQ;
        private String hTR;
        private Context mContext;
        private int mPosition;

        private C0718a(View view, Context context, int i) {
            this.hTR = "";
            this.mContext = context;
            this.hTH = new RelativeLayout[2];
            this.hTI = new TbImageView[2];
            this.hTJ = new TextView[2];
            this.hTK = new TextView[2];
            this.hTL = new LinearLayout[2];
            this.hTM = new TextView[2];
            this.hTP = new TextView[2];
            this.hTN = new TbImageView[2];
            this.hTO = new ViewGroup[2];
            this.hTP[0] = (TextView) view.findViewById(a.f.sdk_ala_left_tv_label);
            this.hTP[1] = (TextView) view.findViewById(a.f.sdk_ala_right_tv_label);
            this.hTN[0] = (TbImageView) view.findViewById(a.f.sdk_ala_left_iv_icon);
            this.hTN[1] = (TbImageView) view.findViewById(a.f.sdk_ala_right_iv_icon);
            this.hTO[0] = (ViewGroup) view.findViewById(a.f.sdk_ala_left_quit_item_icon_container);
            this.hTO[1] = (ViewGroup) view.findViewById(a.f.sdk_ala_right_quit_item_icon_container);
            this.hTH[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.hTH[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.hTI[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.hTI[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.hTJ[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.hTJ[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.hTK[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.hTK[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.hTL[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.hTL[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.hTM[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.hTM[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.hTH[0].getLayoutParams().width = i;
            this.hTH[0].getLayoutParams().height = i;
            this.hTH[1].getLayoutParams().width = i;
            this.hTH[1].getLayoutParams().height = i;
            this.hTI[0].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.hTI[0].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.hTI[1].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.hTI[1].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.hTN[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hTN[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.hTR = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.hTH[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0718a.this.hTQ != null) {
                        if (C0718a.this.hTQ.hUh != null) {
                            C0718a.this.a(C0718a.this.hTQ.hUh);
                        } else if (C0718a.this.hTQ.hUi != null) {
                            C0718a.this.a(C0718a.this.hTQ.hUi);
                        }
                    }
                }
            });
            this.hTH[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0718a.this.hTQ != null && C0718a.this.hTQ.hUi != null) {
                        C0718a.this.a(C0718a.this.hTQ.hUi);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.ala.quitroomrecommend.data.a aVar, int i) {
            boolean z;
            int i2;
            if (aVar != null) {
                this.hTQ = aVar;
                this.mPosition = i;
                if (aVar.hUh != null) {
                    a(aVar.hUh, 0);
                }
                if (aVar.hUi != null) {
                    if (aVar.hUh == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(aVar.hUi, i2);
                } else {
                    z = false;
                }
                if (z) {
                    this.hTH[1].setVisibility(0);
                } else {
                    this.hTH[1].setVisibility(8);
                }
            }
        }

        private void a(AlaQuitRoomRecommendData alaQuitRoomRecommendData, int i) {
            String str = alaQuitRoomRecommendData.cover + this.hTR;
            if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon) && TextUtils.isEmpty(alaQuitRoomRecommendData.labelText)) {
                this.hTO[i].setVisibility(4);
            } else {
                this.hTO[i].setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hTP[i].getLayoutParams();
                if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon)) {
                    layoutParams.leftMargin = 0;
                    this.hTN[i].setVisibility(8);
                } else {
                    this.hTN[i].startLoad(alaQuitRoomRecommendData.labelIcon, 10, false);
                    this.hTN[i].setVisibility(0);
                    layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds4);
                }
                this.hTP[i].setText(alaQuitRoomRecommendData.labelText);
                this.hTP[i].setLayoutParams(layoutParams);
            }
            this.hTI[i].startLoad(str, 10, false);
            this.hTK[i].setText(alaQuitRoomRecommendData.getNameShow());
            this.hTJ[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaQuitRoomRecommendData.audience_count)));
            if (!TextUtils.isEmpty(alaQuitRoomRecommendData.distance) && !TextUtils.equals(alaQuitRoomRecommendData.distance, "0")) {
                this.hTM[i].setText(alaQuitRoomRecommendData.distance);
                this.hTL[i].setVisibility(0);
                return;
            }
            this.hTL[i].setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AlaQuitRoomRecommendData alaQuitRoomRecommendData) {
            if (alaQuitRoomRecommendData != null) {
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            }
        }
    }
}
