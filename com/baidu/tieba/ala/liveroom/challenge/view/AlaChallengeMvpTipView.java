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
import com.baidu.live.data.bb;
import com.baidu.live.sdk.a;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaChallengeMvpTipView extends LinearLayout {
    private TranslateAnimation aZa;
    private LinearLayout gfP;
    private Handler handler;
    private final CustomMessageListener hok;
    private ImageView hom;
    private Queue<a> hon;
    private boolean hoo;
    private final CustomMessageListener hop;
    private TextView mContentText;

    /* loaded from: classes4.dex */
    public static class a {
        public CharSequence text;
        public int hov = 1;
        public long duration = 4500;
    }

    public AlaChallengeMvpTipView(Context context) {
        super(context);
        this.hon = new LinkedList();
        this.handler = new Handler();
        this.hoo = false;
        this.hop = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dL((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.hok = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    AlaChallengeMvpTipView.this.b((bb) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hon = new LinkedList();
        this.handler = new Handler();
        this.hoo = false;
        this.hop = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dL((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.hok = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    AlaChallengeMvpTipView.this.b((bb) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hon = new LinkedList();
        this.handler = new Handler();
        this.hoo = false;
        this.hop = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dL((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.hok = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                    AlaChallengeMvpTipView.this.b((bb) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds12), 0, getResources().getDimensionPixelOffset(a.d.sdk_ds12), 0);
        LayoutInflater.from(getContext()).inflate(a.g.ala_challenge_mvp_tip_layout, (ViewGroup) this, true);
        this.hom = (ImageView) findViewById(a.f.id_challenge_mvp_tip_icon);
        this.mContentText = (TextView) findViewById(a.f.id_challenge_mvp_tip_content);
        this.gfP = (LinearLayout) findViewById(a.f.id_challenge_mvp_tip_content_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a cei() {
        return this.hon.peek();
    }

    public void next() {
        a poll;
        if (!this.hoo && (poll = this.hon.poll()) != null) {
            b(poll);
        }
    }

    public void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.text) && aVar.hov > 0) {
            this.hon.add(aVar);
        }
    }

    public void b(a aVar) {
        setVisibility(0);
        c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(bb bbVar) {
        if (bbVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!StringUtils.isNull(bbVar.mNickName)) {
                int color = getResources().getColor(a.c.sdk_white_alpha100);
                int length = bbVar.mNickName.length();
                String format = String.format(getResources().getString(a.h.ala_challenge_pk_mvp_tip), bbVar.mNickName);
                SpannableString valueOf = SpannableString.valueOf(format);
                valueOf.setSpan(new ForegroundColorSpan(color), 0, format.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.c.sdk_color_F7E51B)), 3, length + 3, 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (spannableStringBuilder != null && spannableStringBuilder.length() > 0) {
                a aVar = new a();
                aVar.hov = 3;
                aVar.text = spannableStringBuilder;
                a(aVar);
                next();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dL(JSONObject jSONObject) {
        if (jSONObject != null) {
            a aVar = null;
            if (TextUtils.equals(jSONObject.optString("content_type"), "challenge_mvp_punish")) {
                aVar = dM(jSONObject);
            }
            if (aVar != null) {
                a(aVar);
            }
            next();
        }
    }

    private a dM(JSONObject jSONObject) {
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
        aVar.hov = 2;
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
        final /* synthetic */ int hor;
        final /* synthetic */ a hos;

        AnonymousClass3(int i, a aVar) {
            this.hor = i;
            this.hos = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = ((AlaChallengeMvpTipView.this.getWidth() - AlaChallengeMvpTipView.this.getPaddingLeft()) - AlaChallengeMvpTipView.this.getPaddingRight()) - AlaChallengeMvpTipView.this.hom.getWidth();
            int i = this.hor;
            float f = -(((i - width) * 1.0f) / width);
            if (i < width) {
                f = 0.0f;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeMvpTipView.this.gfP.getLayoutParams();
            if (i < width) {
                layoutParams.width = -2;
                AlaChallengeMvpTipView.this.gfP.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i;
                AlaChallengeMvpTipView.this.gfP.setLayoutParams(layoutParams);
            }
            AlaChallengeMvpTipView.this.aZa = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
            long j = this.hos.duration;
            if (j <= 0) {
                j = 4500;
            }
            AlaChallengeMvpTipView.this.aZa.setDuration(j);
            AlaChallengeMvpTipView.this.aZa.setFillAfter(false);
            AlaChallengeMvpTipView.this.aZa.setStartOffset(1000L);
            AlaChallengeMvpTipView.this.aZa.setRepeatCount(this.hos.hov - 1);
            AlaChallengeMvpTipView.this.aZa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.3.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    AlaChallengeMvpTipView.this.hoo = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaChallengeMvpTipView.this.hoo = false;
                    if (AlaChallengeMvpTipView.this.cei() != null) {
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
            AlaChallengeMvpTipView.this.gfP.clearAnimation();
            AlaChallengeMvpTipView.this.gfP.startAnimation(AlaChallengeMvpTipView.this.aZa);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.hok);
        MessageManager.getInstance().registerListener(this.hop);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.hok);
        MessageManager.getInstance().unRegisterListener(this.hop);
        IT();
        setVisibility(4);
    }

    public void IT() {
        this.handler.removeCallbacksAndMessages(null);
        this.hon.clear();
        this.gfP.clearAnimation();
        this.hoo = false;
    }
}
