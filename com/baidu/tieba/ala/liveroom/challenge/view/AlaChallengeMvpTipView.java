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
import com.baidu.live.data.aq;
import com.baidu.live.sdk.a;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaChallengeMvpTipView extends LinearLayout {
    private TranslateAnimation aPx;
    private LinearLayout fum;
    private final CustomMessageListener gvt;
    private ImageView gvv;
    private Queue<a> gvw;
    private boolean gvx;
    private final CustomMessageListener gvy;
    private Handler handler;
    private TextView mContentText;

    /* loaded from: classes7.dex */
    public static class a {
        public CharSequence text;
        public int gvE = 1;
        public long duration = 4500;
    }

    public AlaChallengeMvpTipView(Context context) {
        super(context);
        this.gvw = new LinkedList();
        this.handler = new Handler();
        this.gvx = false;
        this.gvy = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dt((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.gvt = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof aq)) {
                    AlaChallengeMvpTipView.this.b((aq) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvw = new LinkedList();
        this.handler = new Handler();
        this.gvx = false;
        this.gvy = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dt((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.gvt = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof aq)) {
                    AlaChallengeMvpTipView.this.b((aq) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvw = new LinkedList();
        this.handler = new Handler();
        this.gvx = false;
        this.gvy = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.dt((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.gvt = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof aq)) {
                    AlaChallengeMvpTipView.this.b((aq) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds12), 0, getResources().getDimensionPixelOffset(a.e.sdk_ds12), 0);
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_mvp_tip_layout, (ViewGroup) this, true);
        this.gvv = (ImageView) findViewById(a.g.id_challenge_mvp_tip_icon);
        this.mContentText = (TextView) findViewById(a.g.id_challenge_mvp_tip_content);
        this.fum = (LinearLayout) findViewById(a.g.id_challenge_mvp_tip_content_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a bQB() {
        return this.gvw.peek();
    }

    public void next() {
        a poll;
        if (!this.gvx && (poll = this.gvw.poll()) != null) {
            b(poll);
        }
    }

    public void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.text) && aVar.gvE > 0) {
            this.gvw.add(aVar);
        }
    }

    public void b(a aVar) {
        setVisibility(0);
        c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(aq aqVar) {
        if (aqVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!StringUtils.isNull(aqVar.mNickName)) {
                int color = getResources().getColor(a.d.sdk_white_alpha100);
                int length = aqVar.mNickName.length();
                String format = String.format(getResources().getString(a.i.ala_challenge_pk_mvp_tip), aqVar.mNickName);
                SpannableString valueOf = SpannableString.valueOf(format);
                valueOf.setSpan(new ForegroundColorSpan(color), 0, format.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_F7E51B)), 3, length + 3, 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (spannableStringBuilder != null && spannableStringBuilder.length() > 0) {
                a aVar = new a();
                aVar.gvE = 3;
                aVar.text = spannableStringBuilder;
                a(aVar);
                next();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt(JSONObject jSONObject) {
        if (jSONObject != null) {
            a aVar = null;
            if (TextUtils.equals(jSONObject.optString("content_type"), "challenge_mvp_punish")) {
                aVar = du(jSONObject);
            }
            if (aVar != null) {
                a(aVar);
            }
            next();
        }
    }

    private a du(JSONObject jSONObject) {
        String format;
        int optInt = jSONObject.optInt("punish_type");
        String optString = jSONObject.optString("mvp_nickname");
        String optString2 = jSONObject.optString("sticker_name");
        if (optInt == 1) {
            format = String.format(getResources().getString(a.i.txt_challenge_mvp_punish_choose), optString, optString2);
        } else if (optInt == 2) {
            format = String.format(getResources().getString(a.i.txt_challenge_mvp_punish_letoff), optString);
        } else {
            format = optInt == 3 ? String.format(getResources().getString(a.i.txt_challenge_mvp_punish_notchoose), optString, optString2) : null;
        }
        if (format == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString valueOf = SpannableString.valueOf(format);
        valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_white_alpha100)), 0, format.length(), 33);
        valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_F7E51B)), 4, optString.length() + 4, 33);
        spannableStringBuilder.append((CharSequence) valueOf);
        a aVar = new a();
        aVar.gvE = 2;
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
    /* loaded from: classes7.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ int gvA;
        final /* synthetic */ a gvB;

        AnonymousClass3(int i, a aVar) {
            this.gvA = i;
            this.gvB = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = ((AlaChallengeMvpTipView.this.getWidth() - AlaChallengeMvpTipView.this.getPaddingLeft()) - AlaChallengeMvpTipView.this.getPaddingRight()) - AlaChallengeMvpTipView.this.gvv.getWidth();
            int i = this.gvA;
            float f = -(((i - width) * 1.0f) / width);
            if (i < width) {
                f = 0.0f;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AlaChallengeMvpTipView.this.fum.getLayoutParams();
            if (i < width) {
                layoutParams.width = -2;
                AlaChallengeMvpTipView.this.fum.setLayoutParams(layoutParams);
            } else {
                layoutParams.width = i;
                AlaChallengeMvpTipView.this.fum.setLayoutParams(layoutParams);
            }
            AlaChallengeMvpTipView.this.aPx = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
            long j = this.gvB.duration;
            if (j <= 0) {
                j = 4500;
            }
            AlaChallengeMvpTipView.this.aPx.setDuration(j);
            AlaChallengeMvpTipView.this.aPx.setFillAfter(false);
            AlaChallengeMvpTipView.this.aPx.setStartOffset(1000L);
            AlaChallengeMvpTipView.this.aPx.setRepeatCount(this.gvB.gvE - 1);
            AlaChallengeMvpTipView.this.aPx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.3.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    AlaChallengeMvpTipView.this.gvx = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaChallengeMvpTipView.this.gvx = false;
                    if (AlaChallengeMvpTipView.this.bQB() != null) {
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
            AlaChallengeMvpTipView.this.fum.clearAnimation();
            AlaChallengeMvpTipView.this.fum.startAnimation(AlaChallengeMvpTipView.this.aPx);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.gvt);
        MessageManager.getInstance().registerListener(this.gvy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.gvt);
        MessageManager.getInstance().unRegisterListener(this.gvy);
        Ft();
        setVisibility(4);
    }

    public void Ft() {
        this.handler.removeCallbacksAndMessages(null);
        this.gvw.clear();
        this.fum.clearAnimation();
        this.gvx = false;
    }
}
