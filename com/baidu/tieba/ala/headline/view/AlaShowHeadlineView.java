package com.baidu.tieba.ala.headline.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.widget.CenteredImageSpan;
import com.baidu.live.ap.c;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.view.b;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaShowHeadlineView extends RelativeLayout {
    x aBr;
    private TextView hbp;
    public long hbr;
    public RelativeLayout hci;
    public RelativeLayout hcj;
    private Button hck;
    private Button hcl;
    private RelativeLayout hcm;
    private TextView hcn;
    private TextView hco;
    private TextView hcp;
    private TextView hcq;
    public TextView hcr;
    private HeadImageView hcs;
    private HeadImageView hct;
    private TextView hcu;
    private Bitmap hcv;
    AlaLiveMarkData hcw;
    public Button hcx;
    private Activity mActivity;
    Context mContext;
    private View mView;
    String otherParams;

    public AlaShowHeadlineView(Context context) {
        super(context);
        this.otherParams = "";
    }

    public AlaShowHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaShowHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_show_headline_dialog, (ViewGroup) this, true);
        this.hci = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_layout);
        this.hcj = (RelativeLayout) this.mView.findViewById(a.f.show_view_richer_view);
        this.hck = (Button) this.mView.findViewById(a.f.show_view_go_look);
        this.hbp = (TextView) this.mView.findViewById(a.f.show_view_get_headline_support);
        this.hcx = (Button) this.mView.findViewById(a.f.show_view_horizontal_close_button);
        this.hcx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.hcm = (RelativeLayout) this.mView.findViewById(a.f.show_view_nobody_gifts_tip);
        this.hcn = (TextView) this.mView.findViewById(a.f.show_view_nobody_score);
        this.hco = (TextView) this.mView.findViewById(a.f.show_view_got_gifts_tip);
        this.hcs = (HeadImageView) this.mView.findViewById(a.f.show_view_live_head);
        this.hct = (HeadImageView) this.mView.findViewById(a.f.show_view_richer_head);
        this.hcq = (TextView) this.mView.findViewById(a.f.show_view_richer_head_name);
        this.hcp = (TextView) this.mView.findViewById(a.f.show_view_live_head_name);
        this.hcr = (TextView) this.mView.findViewById(a.f.show_view_timer);
        this.hcu = (TextView) this.mView.findViewById(a.f.show_view_tip);
        this.hcl = (Button) this.mView.findViewById(a.f.show_view_get_headline);
        this.hck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaShowHeadlineView.this.A(AlaShowHeadlineView.this.aBr);
                AlaShowHeadlineView.this.mActivity.finish();
            }
        });
        this.hbp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaShowHeadlineView.this.aBr.aGf.aFg;
                cVar.bSt = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.hcs.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hcs.setIsRound(true);
        this.hcs.setAutoChangeStyle(false);
        this.hcs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hct.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hct.setIsRound(true);
        this.hct.setAutoChangeStyle(false);
        this.hct.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(x xVar) {
        JSONObject jSONObject;
        com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(xVar.aGf.liveId)));
        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(TbadkCoreApplication.getInst().getApplicationContext());
        alaLiveRoomActivityConfig.addExtraByLiveId(xVar.aGf.liveId, "", "live_sdk");
        try {
            String flvUrl = xVar.mLiveInfo.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT);
            String str = xVar.mLiveInfo.cover;
            String valueOf = String.valueOf(xVar.mLiveInfo.room_id);
            String valueOf2 = String.valueOf(xVar.mLiveInfo.live_id);
            if (TextUtils.isEmpty(this.otherParams)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.otherParams);
            }
            jSONObject.put("live_url", flvUrl);
            jSONObject.put("cover", str);
            jSONObject.put("enterRoomId", valueOf);
            jSONObject.put("enterLiveId", valueOf2);
            jSONObject.put("screen_direction", xVar.mLiveInfo.screen_direction);
            this.otherParams = jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        alaLiveRoomActivityConfig.addExtraByParams(this.otherParams);
        alaLiveRoomActivityConfig.setNeedStopImWhenClose(true);
        com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
    }

    public void setData(x xVar, String str) {
        this.otherParams = str;
        if (this.hbr > 0 && xVar.aGf.aEW > 0 && xVar.aGf.aEY > xVar.aGf.aEW) {
            setGetLineView(xVar);
        } else {
            setNobodyLayout(xVar);
        }
        B(xVar);
    }

    public void setGetLineView(x xVar) {
        this.hci.setVisibility(8);
        this.hck.setVisibility(0);
        this.hcj.setVisibility(0);
        this.hcm.setVisibility(8);
        this.hco.setVisibility(0);
        setGiftTipString(xVar);
        this.hcs.startLoad(xVar.aGf.aFd, 12, false);
        this.hct.startLoad(xVar.aGf.aFe, 12, false);
        this.hcq.setText(xVar.aGf.userName);
        this.hcp.setText(xVar.aGf.aFc);
        this.hcu.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_get_tip));
        this.hcl.setBackgroundResource(a.e.sdk_get_headline_button_small);
    }

    public void setNobodyLayout(x xVar) {
        this.hci.setVisibility(0);
        this.hck.setVisibility(8);
        this.hcj.setVisibility(8);
        this.hcm.setVisibility(0);
        this.hco.setVisibility(8);
        this.hcn.setText(com.baidu.tieba.ala.headline.a.fm(xVar.aGf.aEW));
        this.hcu.setText(this.mContext.getString(a.h.sdk_get_headline_show_view_tip));
        this.hcl.setBackgroundResource(a.e.sdk_get_headline);
    }

    private void B(x xVar) {
        if (xVar.isHost) {
            this.hck.setVisibility(8);
            this.hcl.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.hbp.getLayoutParams()).topMargin = getContext().getResources().getDimensionPixelSize(a.d.sdk_ds40);
        }
        if (xVar.mLiveInfo.live_id == xVar.aGf.liveId) {
            this.hck.setVisibility(8);
            this.hcl.setBackgroundResource(a.e.sdk_get_headline);
        }
        this.aBr = xVar;
    }

    private void setGiftTipString(x xVar) {
        if (this.hcw == null || this.hcw.mark_id != xVar.aGf.aEY) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(" " + this.mContext.getString(a.h.sdk_get_headline_send, xVar.aGf.giftName));
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            if (this.hcw == null || !this.hcw.mark_pic.equals(xVar.aGf.aFb)) {
                this.hcw = new AlaLiveMarkData();
                this.hcw.mark_pic = xVar.aGf.aFb;
                this.hcw.isWidthAutoFit = true;
                com.baidu.live.view.b bVar = new com.baidu.live.view.b(this.mContext, this.hcw, false, new b.a() { // from class: com.baidu.tieba.ala.headline.view.AlaShowHeadlineView.4
                    @Override // com.baidu.live.view.b.a
                    public void e(Bitmap bitmap) {
                        AlaShowHeadlineView.this.hco.setText(AlaShowHeadlineView.this.hco.getText());
                        AlaShowHeadlineView.this.hcv = bitmap;
                    }

                    @Override // com.baidu.live.view.b.a
                    public void a(com.baidu.live.view.b bVar2, Bitmap bitmap) {
                    }
                });
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder2.setSpan(bVar, 1, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            } else {
                CenteredImageSpan centeredImageSpan = new CenteredImageSpan(getContext(), this.hcv);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(" [img]");
                spannableStringBuilder3.setSpan(centeredImageSpan, 1, spannableStringBuilder3.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
            }
            this.hcw.mark_id = xVar.aGf.aEY;
            SpannableString spannableString2 = new SpannableString(this.mContext.getString(a.h.sdk_get_headline_worth, xVar.aGf.giftNum + ""));
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFFFFF")), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            CenteredImageSpan centeredImageSpan2 = new CenteredImageSpan(getContext(), BitmapFactory.decodeResource(getContext().getResources(), a.e.sdk_icon_huobi_tdou));
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(" [img]");
            spannableStringBuilder4.setSpan(centeredImageSpan2, 1, spannableStringBuilder4.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
            SpannableString spannableString3 = new SpannableString(com.baidu.tieba.ala.headline.a.fm(xVar.aGf.aFa));
            spannableString3.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFACA21")), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hco.setText(spannableStringBuilder);
        }
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
