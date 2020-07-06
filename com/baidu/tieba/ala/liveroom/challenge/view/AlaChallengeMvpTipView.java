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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.an;
import com.baidu.live.sdk.a;
import java.util.LinkedList;
import java.util.Queue;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaChallengeMvpTipView extends LinearLayout {
    private TranslateAnimation aIO;
    private LinearLayout fdX;
    private final CustomMessageListener geh;
    private int gej;
    private Queue<a> gek;
    private boolean gel;
    private final CustomMessageListener gem;
    private Handler handler;
    private TextView mContentText;
    private int mScreenWidth;

    /* loaded from: classes3.dex */
    public static class a {
        public CharSequence text;
        public int geq = 1;
        public long duration = 4500;
    }

    public AlaChallengeMvpTipView(Context context) {
        super(context);
        this.gek = new LinkedList();
        this.handler = new Handler();
        this.gel = false;
        this.gem = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.de((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.geh = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an)) {
                    AlaChallengeMvpTipView.this.b((an) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gek = new LinkedList();
        this.handler = new Handler();
        this.gel = false;
        this.gem = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.de((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.geh = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an)) {
                    AlaChallengeMvpTipView.this.b((an) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    public AlaChallengeMvpTipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gek = new LinkedList();
        this.handler = new Handler();
        this.gel = false;
        this.gem = new CustomMessageListener(2913213) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                    AlaChallengeMvpTipView.this.de((JSONObject) customResponsedMessage.getData());
                }
            }
        };
        this.geh = new CustomMessageListener(2913205) { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof an)) {
                    AlaChallengeMvpTipView.this.b((an) customResponsedMessage.getData());
                }
            }
        };
        init();
    }

    private void init() {
        this.gej = getResources().getDimensionPixelOffset(a.e.sdk_ds360);
        this.mScreenWidth = BdUtilHelper.getEquipmentWidth(getContext());
        LayoutInflater.from(getContext()).inflate(a.h.ala_challenge_mvp_tip_layout, (ViewGroup) this, true);
        this.mContentText = (TextView) findViewById(a.g.id_challenge_mvp_tip_content);
        this.fdX = (LinearLayout) findViewById(a.g.id_challenge_mvp_tip_content_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a bDM() {
        return this.gek.peek();
    }

    public void next() {
        a poll;
        if (!this.gel && (poll = this.gek.poll()) != null) {
            b(poll);
        }
    }

    public void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.text) && aVar.geq > 0) {
            this.gek.add(aVar);
        }
    }

    public void b(a aVar) {
        setVisibility(0);
        c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(an anVar) {
        if (anVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!StringUtils.isNull(anVar.mNickName)) {
                int color = getResources().getColor(a.d.sdk_white_alpha100);
                int length = anVar.mNickName.length();
                String format = String.format(getResources().getString(a.i.ala_challenge_pk_mvp_tip), anVar.mNickName);
                SpannableString valueOf = SpannableString.valueOf(format);
                valueOf.setSpan(new ForegroundColorSpan(color), 0, format.length(), 33);
                valueOf.setSpan(new ForegroundColorSpan(getResources().getColor(a.d.sdk_color_F7E51B)), 3, length + 3, 33);
                spannableStringBuilder.append((CharSequence) valueOf);
            }
            if (spannableStringBuilder != null && spannableStringBuilder.length() > 0) {
                a aVar = new a();
                aVar.geq = 3;
                aVar.text = spannableStringBuilder;
                a(aVar);
                next();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(JSONObject jSONObject) {
        if (jSONObject != null) {
            a aVar = null;
            if (TextUtils.equals(jSONObject.optString("content_type"), "challenge_mvp_punish")) {
                aVar = df(jSONObject);
            }
            if (aVar != null) {
                a(aVar);
            }
            next();
        }
    }

    private a df(JSONObject jSONObject) {
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
        aVar.geq = 2;
        aVar.text = spannableStringBuilder;
        aVar.duration = 6000L;
        return aVar;
    }

    private void c(a aVar) {
        CharSequence charSequence = aVar.text;
        this.mContentText.setText(charSequence);
        int textWidth = BdUtilHelper.getTextWidth(this.mContentText.getPaint(), charSequence.toString());
        int i = this.mScreenWidth - this.gej;
        float f = -(((textWidth - i) * 1.0f) / i);
        if (textWidth < i) {
            f = 0.0f;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fdX.getLayoutParams();
        if (textWidth < i) {
            layoutParams.width = -2;
            this.fdX.setLayoutParams(layoutParams);
        } else {
            layoutParams.width = textWidth;
            this.fdX.setLayoutParams(layoutParams);
        }
        this.aIO = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
        long j = aVar.duration;
        if (j <= 0) {
            j = 4500;
        }
        this.aIO.setDuration(j);
        this.aIO.setFillAfter(false);
        this.aIO.setStartOffset(1000L);
        this.aIO.setRepeatCount(aVar.geq - 1);
        this.aIO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                AlaChallengeMvpTipView.this.gel = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaChallengeMvpTipView.this.gel = false;
                if (AlaChallengeMvpTipView.this.bDM() != null) {
                    AlaChallengeMvpTipView.this.handler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.AlaChallengeMvpTipView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AlaChallengeMvpTipView.this.next();
                        }
                    });
                } else {
                    AlaChallengeMvpTipView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.fdX.clearAnimation();
        this.fdX.startAnimation(this.aIO);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.geh);
        MessageManager.getInstance().registerListener(this.gem);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.geh);
        MessageManager.getInstance().unRegisterListener(this.gem);
        zo();
        setVisibility(8);
    }

    public void zo() {
        this.handler.removeCallbacksAndMessages(null);
        this.gek.clear();
        this.fdX.clearAnimation();
        this.gel = false;
    }
}
