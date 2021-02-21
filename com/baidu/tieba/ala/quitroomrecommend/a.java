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
        coM();
    }

    public void setData(List<com.baidu.tieba.ala.quitroomrecommend.data.a> list) {
        this.mDatas = list;
        notifyDataSetChanged();
    }

    private void coM() {
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
        C0694a c0694a;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_recommend_live_item_layout, viewGroup, false);
            C0694a c0694a2 = new C0694a(view, this.mContext, this.cardWidth);
            view.setTag(c0694a2);
            c0694a = c0694a2;
        } else {
            c0694a = (C0694a) view.getTag();
        }
        c0694a.a(this.mDatas.get(i), i);
        return view;
    }

    /* renamed from: com.baidu.tieba.ala.quitroomrecommend.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0694a {
        private RelativeLayout[] igi;
        private TbImageView[] igj;
        private TextView[] igk;
        private TextView[] igl;
        private LinearLayout[] igm;
        private TextView[] ign;
        private TbImageView[] igo;
        private ViewGroup[] igp;
        private TextView[] igq;
        private com.baidu.tieba.ala.quitroomrecommend.data.a igr;
        private String igs;
        private Context mContext;
        private int mPosition;

        private C0694a(View view, Context context, int i) {
            this.igs = "";
            this.mContext = context;
            this.igi = new RelativeLayout[2];
            this.igj = new TbImageView[2];
            this.igk = new TextView[2];
            this.igl = new TextView[2];
            this.igm = new LinearLayout[2];
            this.ign = new TextView[2];
            this.igq = new TextView[2];
            this.igo = new TbImageView[2];
            this.igp = new ViewGroup[2];
            this.igq[0] = (TextView) view.findViewById(a.f.sdk_ala_left_tv_label);
            this.igq[1] = (TextView) view.findViewById(a.f.sdk_ala_right_tv_label);
            this.igo[0] = (TbImageView) view.findViewById(a.f.sdk_ala_left_iv_icon);
            this.igo[1] = (TbImageView) view.findViewById(a.f.sdk_ala_right_iv_icon);
            this.igp[0] = (ViewGroup) view.findViewById(a.f.sdk_ala_left_quit_item_icon_container);
            this.igp[1] = (ViewGroup) view.findViewById(a.f.sdk_ala_right_quit_item_icon_container);
            this.igi[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.igi[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.igj[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.igj[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.igk[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.igk[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.igl[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.igl[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.igm[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.igm[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ign[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ign[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.igi[0].getLayoutParams().width = i;
            this.igi[0].getLayoutParams().height = i;
            this.igi[1].getLayoutParams().width = i;
            this.igi[1].getLayoutParams().height = i;
            this.igj[0].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.igj[0].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.igj[1].setDefaultBgResource(a.e.sdk_shape_quit_room_item_bg);
            this.igj[1].setDefaultErrorResource(a.e.sdk_shape_quit_room_item_bg);
            this.igo[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.igo[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.igs = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.igi[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0694a.this.igr != null) {
                        if (C0694a.this.igr.igI != null) {
                            C0694a.this.a(C0694a.this.igr.igI);
                        } else if (C0694a.this.igr.igJ != null) {
                            C0694a.this.a(C0694a.this.igr.igJ);
                        }
                    }
                }
            });
            this.igi[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0694a.this.igr != null && C0694a.this.igr.igJ != null) {
                        C0694a.this.a(C0694a.this.igr.igJ);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.ala.quitroomrecommend.data.a aVar, int i) {
            boolean z;
            int i2;
            if (aVar != null) {
                this.igr = aVar;
                this.mPosition = i;
                if (aVar.igI != null) {
                    a(aVar.igI, 0);
                }
                if (aVar.igJ != null) {
                    if (aVar.igI == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(aVar.igJ, i2);
                } else {
                    z = false;
                }
                if (z) {
                    this.igi[1].setVisibility(0);
                } else {
                    this.igi[1].setVisibility(8);
                }
            }
        }

        private void a(AlaQuitRoomRecommendData alaQuitRoomRecommendData, int i) {
            String str = alaQuitRoomRecommendData.cover + this.igs;
            if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon) && TextUtils.isEmpty(alaQuitRoomRecommendData.labelText)) {
                this.igp[i].setVisibility(4);
            } else {
                this.igp[i].setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.igq[i].getLayoutParams();
                if (TextUtils.isEmpty(alaQuitRoomRecommendData.labelIcon)) {
                    layoutParams.leftMargin = 0;
                    this.igo[i].setVisibility(8);
                } else {
                    this.igo[i].startLoad(alaQuitRoomRecommendData.labelIcon, 10, false);
                    this.igo[i].setVisibility(0);
                    layoutParams.leftMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds4);
                }
                this.igq[i].setText(alaQuitRoomRecommendData.labelText);
                this.igq[i].setLayoutParams(layoutParams);
            }
            this.igj[i].startLoad(str, 10, false);
            this.igl[i].setText(alaQuitRoomRecommendData.getNameShow());
            this.igk[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaQuitRoomRecommendData.audience_count)));
            if (!TextUtils.isEmpty(alaQuitRoomRecommendData.distance) && !TextUtils.equals(alaQuitRoomRecommendData.distance, "0")) {
                this.ign[i].setText(alaQuitRoomRecommendData.distance);
                this.igm[i].setVisibility(0);
                return;
            }
            this.igm[i].setVisibility(8);
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
