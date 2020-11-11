package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ba;
import com.baidu.live.sdk.a;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaChallengeMvpTipView extends LinearLayout {
    private TranslateAnimation aXz;
    private LinearLayout fXV;
    private Handler handler;
    private final CustomMessageListener heT;
    private ImageView heV;
    private Queue<a> heW;
    private boolean heX;
    private final CustomMessageListener heY;
    private TextView mContentText;

    /* loaded from: classes4.dex */
    public static class a {
        public CharSequence text;
        public int hfe = 1;
        public long duration = 4500;
    }

    public AlaChallengeMvpTipView(Context context) {
        super(context);
        this.heW = new LinkedList();
        this.handler = new Handler();
        this.heX = false;
        this.heY = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dP((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.heT = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ba)) {
                    AlaChallengeMvpTipView.this.b((ba) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heW = new LinkedList();
        this.handler = new Handler();
        this.heX = false;
        this.heY = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dP((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.heT = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ba)) {
                    AlaChallengeMvpTipView.this.b((ba) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.heW = new LinkedList();
        this.handler = new Handler();
        this.heX = false;
        this.heY = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dP((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.heT = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof ba)) {
                    AlaChallengeMvpTipView.this.b((ba) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds12), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds12), 0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_mvp_tip_layout, (ViewGroup) this, true);
        this.heV = (ImageView) findViewById(a.f.id_challenge_mvp_tip_icon);
        this.mContentText = (TextView) findViewById(a.f.id_challenge_mvp_tip_content);
        this.fXV = (LinearLayout) findViewById(a.f.id_challenge_mvp_tip_content_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a caT() {
        return this.heW.peek();
    }

    public void next() {
        a poll;
        if (!this.heX && (poll = this.heW.poll()) != null) {
            b(poll);
        }
    }

    public void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.text) && aVar.hfe > 0) {
            this.heW.add(aVar);
        }
    }

    public void b(a aVar) {
        setVisibility(0);
        c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ba baVar) {
        if (baVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!StringUtils.isNull(baVar.mNickName)) {
                int color = getResources().getColor(a.c.sdk_white_alpha100);
                int length = baVar.mNickName.length();
                String format = String.format(getResources().getString(a.h.ala_challenge_pk_mvp_tip), baVar.mNickName);
                SpannableString valueOf = SpannableString.valueOf(format);
                valueOf.setSpan(new ForegroundColorSpan(color), 0, format.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_color_F7E51B)), 3, length + 3, 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (spannableStringBuilder != null && spannableStringBuilder.length() > 0) {
                a aVar = new a();
                aVar.hfe = 3;
                aVar.text = spannableStringBuilder;
                a(aVar);
                next();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(JSONObject jSONObject) {
        if (jSONObject != null) {
            a aVar = null;
            if (TextUtils.equals(jSONObject.optString("content_type"), "challenge_mvp_punish")) {
                aVar = dQ(jSONObject);
            }
            if (aVar != null) {
                a(aVar);
            }
            next();
        }
    }

    private a dQ(JSONObject jSONObject) {
        String format;
        int optInt = jSONObject.optInt("punish_type");
        String optString = jSONObject.optString("mvp_nickname");
        String optString2 = jSONObject.optString("sticker_name");
        if (optInt == 1) {
            format = String.format(getResources().getString(a.h.txt_challenge_mvp_punish_choose), optString, optString2);
        } else if (optInt == 2) {
            format = String.format(getResources().getString(a.h.txt_challenge_mvp_punish_letoff), optString);
        } else {
            format = optInt == 3 ? String.format(getResources().getString(a.h.txt_challenge_mvp_punish_notchoose), optString, optString2) : null;
        }
        if (format == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString valueOf = SpannableString.valueOf(format);
        valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_white_alpha100)), 0, format.length(), 33);
        valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_color_F7E51B)), 4, optString.length() + 4, 33);
        spannableStringBuilder.append((CharSequence) valueOf);
        a aVar = new a();
        aVar.hfe = 2;
        aVar.text = spannableStringBuilder;
        aVar.duration = 6000L;
        return aVar;
    }

    private void c(a aVar) {
        CharSequence charSequence = aVar.text;
        this.mContentText.setText(charSequence);
        post(new AnonymousClass3(BdUtilHelper.getTextWidth(this.mContentText.getPaint(), charSequence.toString()), aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ int hfa;
        final /* synthetic */ a hfb;

        AnonymousClass3(int i, a aVar) {
            this.hfa = i;
            this.hfb = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = ((AlaChallengeMvpTipView.this.getWidth() - AlaChallengeMvpTipView.this.getPaddingLeft()) - AlaChallengeMvpTipView.this.getPaddingRight()) - AlaChallengeMvpTipView.this.heV.getWidth();
            int i = this.hfa;
            float f = -(((i - width) * 1.0f) / width);
            if (i < width) {
                f = 0.0f;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeMvpTipView.this.fXV.getLayoutParams();
            if (i < width) {
                layoutParams.width = -2;
                AlaChallengeMvpTipView.this.fXV.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i;
                AlaChallengeMvpTipView.this.fXV.setLayoutParams(layoutParams);
            }
            AlaChallengeMvpTipView.this.aXz = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
            long j = this.hfb.duration;
            if (j <= 0) {
                j = 4500;
            }
            AlaChallengeMvpTipView.this.aXz.setDuration(j);
            AlaChallengeMvpTipView.this.aXz.setFillAfter(false);
            AlaChallengeMvpTipView.this.aXz.setStartOffset(1000L);
            AlaChallengeMvpTipView.this.aXz.setRepeatCount(this.hfb.hfe - 1);
            AlaChallengeMvpTipView.this.aXz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.3.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    AlaChallengeMvpTipView.this.heX = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaChallengeMvpTipView.this.heX = false;
                    if (AlaChallengeMvpTipView.this.caT() != null) {
                        AlaChallengeMvpTipView.this.handler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaChallengeMvpTipView.this.next();
                            }
                        });
                    } else {
                        AlaChallengeMvpTipView.this.setVisibility(4);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            AlaChallengeMvpTipView.this.fXV.clearAnimation();
            AlaChallengeMvpTipView.this.fXV.startAnimation(AlaChallengeMvpTipView.this.aXz);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.heT);
        MessageManager.getInstance().registerListener(this.heY);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.heT);
        MessageManager.getInstance().unRegisterListener(this.heY);
        HM();
        setVisibility(4);
    }

    public void HM() {
        this.handler.removeCallbacksAndMessages(null);
        this.heW.clear();
        this.fXV.clearAnimation();
        this.heX = false;
    }
}
