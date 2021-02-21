package com.baidu.tieba.ala.liveroom.challenge.view;

import android.content.Context;
import android.os.Handler;
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
import androidx.annotation.Nullable;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.bh;
import com.baidu.live.sdk.a;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaChallengeMvpTipView extends LinearLayout {
    private TranslateAnimation aZb;
    private LinearLayout goh;
    private TextView hAa;
    private Queue<a> hAb;
    private boolean hAc;
    private final CustomMessageListener hAd;
    private Handler handler;
    private final CustomMessageListener hzX;
    private ImageView hzZ;

    /* loaded from: classes11.dex */
    public static class a {
        public CharSequence text;
        public int showCount = 1;
        public long duration = 4500;
    }

    public AlaChallengeMvpTipView(Context context) {
        super(context);
        this.hAb = new LinkedList();
        this.handler = new Handler();
        this.hAc = false;
        this.hAd = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dV((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.hzX = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    AlaChallengeMvpTipView.this.b((bh) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAb = new LinkedList();
        this.handler = new Handler();
        this.hAc = false;
        this.hAd = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dV((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.hzX = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    AlaChallengeMvpTipView.this.b((bh) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAb = new LinkedList();
        this.handler = new Handler();
        this.hAc = false;
        this.hAd = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dV((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.hzX = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bh)) {
                    AlaChallengeMvpTipView.this.b((bh) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds12), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds12), 0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_mvp_tip_layout, (ViewGroup) this, true);
        this.hzZ = (ImageView) findViewById(a.f.id_challenge_mvp_tip_icon);
        this.hAa = (TextView) findViewById(a.f.id_challenge_mvp_tip_content);
        this.goh = (LinearLayout) findViewById(a.f.id_challenge_mvp_tip_content_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a cej() {
        return this.hAb.peek();
    }

    public void next() {
        a poll;
        if (!this.hAc && (poll = this.hAb.poll()) != null) {
            b(poll);
        }
    }

    public void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.text) && aVar.showCount > 0) {
            this.hAb.add(aVar);
        }
    }

    public void b(a aVar) {
        setVisibility(0);
        c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bh bhVar) {
        if (bhVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!StringUtils.isNull(bhVar.mNickName)) {
                int color = getResources().getColor(a.c.sdk_white_alpha100);
                int length = bhVar.mNickName.length();
                String format = String.format(getResources().getString(a.h.ala_challenge_pk_mvp_tip), bhVar.mNickName);
                SpannableString valueOf = SpannableString.valueOf(format);
                valueOf.setSpan(new ForegroundColorSpan(color), 0, format.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_color_F7E51B)), 3, length + 3, 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (spannableStringBuilder != null && spannableStringBuilder.length() > 0) {
                a aVar = new a();
                aVar.showCount = 3;
                aVar.text = spannableStringBuilder;
                a(aVar);
                next();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(JSONObject jSONObject) {
        if (jSONObject != null) {
            a aVar = null;
            if (TextUtils.equals(jSONObject.optString("content_type"), "challenge_mvp_punish")) {
                aVar = dW(jSONObject);
            }
            if (aVar != null) {
                a(aVar);
            }
            next();
        }
    }

    private a dW(JSONObject jSONObject) {
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
        aVar.showCount = 2;
        aVar.text = spannableStringBuilder;
        aVar.duration = 6000L;
        return aVar;
    }

    private void c(a aVar) {
        CharSequence charSequence = aVar.text;
        this.hAa.setText(charSequence);
        post(new AnonymousClass3(BdUtilHelper.getTextWidth(this.hAa.getPaint(), charSequence.toString()), aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ int hAf;
        final /* synthetic */ a hAg;

        AnonymousClass3(int i, a aVar) {
            this.hAf = i;
            this.hAg = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = ((AlaChallengeMvpTipView.this.getWidth() - AlaChallengeMvpTipView.this.getPaddingLeft()) - AlaChallengeMvpTipView.this.getPaddingRight()) - AlaChallengeMvpTipView.this.hzZ.getWidth();
            int i = this.hAf;
            float f = -(((i - width) * 1.0f) / width);
            if (i < width) {
                f = 0.0f;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeMvpTipView.this.goh.getLayoutParams();
            if (i < width) {
                layoutParams.width = -2;
                AlaChallengeMvpTipView.this.goh.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i;
                AlaChallengeMvpTipView.this.goh.setLayoutParams(layoutParams);
            }
            AlaChallengeMvpTipView.this.aZb = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
            long j = this.hAg.duration;
            if (j <= 0) {
                j = 4500;
            }
            AlaChallengeMvpTipView.this.aZb.setDuration(j);
            AlaChallengeMvpTipView.this.aZb.setFillAfter(false);
            AlaChallengeMvpTipView.this.aZb.setStartOffset(1000L);
            AlaChallengeMvpTipView.this.aZb.setRepeatCount(this.hAg.showCount - 1);
            AlaChallengeMvpTipView.this.aZb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.3.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    AlaChallengeMvpTipView.this.hAc = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaChallengeMvpTipView.this.hAc = false;
                    if (AlaChallengeMvpTipView.this.cej() != null) {
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
            AlaChallengeMvpTipView.this.goh.clearAnimation();
            AlaChallengeMvpTipView.this.goh.startAnimation(AlaChallengeMvpTipView.this.aZb);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hzX);
        MessageManager.getInstance().registerListener(this.hAd);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.hzX);
        MessageManager.getInstance().unRegisterListener(this.hAd);
        FP();
        setVisibility(4);
    }

    public void FP() {
        this.handler.removeCallbacksAndMessages(null);
        this.hAb.clear();
        this.goh.clearAnimation();
        this.hAc = false;
    }
}
