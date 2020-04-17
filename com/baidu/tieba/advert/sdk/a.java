package com.baidu.tieba.advert.sdk;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdType;
import com.baidu.tieba.advert.sdk.data.RedirectType;
import com.baidu.tieba.advert.sdk.view.SplashAdView;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class a {
    private C0443a eCC = null;
    private String eCD = null;
    private WeakReference<SplashAdView> eCE;

    public void xC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, new CustomMessageTask.CustomRunnable<j>() { // from class: com.baidu.tieba.advert.sdk.a.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<j> customMessage) {
                if (customMessage == null || customMessage.getCmd() != 2016310) {
                    return null;
                }
                try {
                    return new CustomResponsedMessage<>(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, a.this.a(customMessage.getData()));
                } catch (Exception e) {
                    return null;
                }
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(j jVar) {
        boolean z;
        if (jVar == null || !jVar.isAvailable()) {
            return null;
        }
        Activity pageActivity = jVar.aRS().getPageActivity();
        int asL = jVar.asL();
        int asK = jVar.asK();
        final SplashAdView splashAdView = new SplashAdView(jVar.aRS(), "1481698145541", AdType.SPLASH, asL, asK, RedirectType.APPMANAGE);
        splashAdView.setLayoutParams(new RelativeLayout.LayoutParams(asK, asL));
        this.eCE = new WeakReference<>(splashAdView);
        splashAdView.setBCAdCallBack(new com.baidu.tieba.advert.sdk.a.a() { // from class: com.baidu.tieba.advert.sdk.a.2
            @Override // com.baidu.tieba.advert.sdk.a.a
            public void bhn() {
                com.baidu.tieba.advert.sdk.data.b entryInfoData;
                SplashAdView splashAdView2 = (SplashAdView) a.this.eCE.get();
                if (splashAdView2 != null) {
                    a.this.eCD = splashAdView.bhB();
                    a.this.yK(a.this.eCD);
                }
                an anVar = new an("c13319");
                if (splashAdView2 != null && (entryInfoData = splashAdView2.getEntryInfoData()) != null) {
                    if (entryInfoData.bhr()) {
                        anVar.cI("obj_source", entryInfoData.videoJumpUrl);
                    } else {
                        anVar.cI("obj_source", entryInfoData.redirectUrl);
                    }
                }
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.advert.sdk.a.a
            public void a(com.baidu.tieba.advert.sdk.data.a aVar) {
            }

            @Override // com.baidu.tieba.advert.sdk.a.a
            public void bho() {
            }

            @Override // com.baidu.tieba.advert.sdk.a.a
            public void bhp() {
            }

            @Override // com.baidu.tieba.advert.sdk.a.a
            public void yL(String str) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, str));
                an anVar = new an("c13320");
                anVar.cI("obj_source", str);
                TiebaStatic.log(anVar);
            }
        });
        try {
            z = splashAdView.bhA();
        } catch (Throwable th) {
            z = false;
        }
        if (z) {
            try {
                int dimension = (int) pageActivity.getResources().getDimension(R.dimen.ds22);
                int dimension2 = (int) pageActivity.getResources().getDimension(R.dimen.ds36);
                Activity pageActivity2 = jVar.aRS().getPageActivity();
                int statusBarHeight = (UtilHelper.isNotchScreen(pageActivity2) || UtilHelper.isCutoutScreen(pageActivity2)) ? dimension2 + l.getStatusBarHeight(pageActivity2) : dimension2;
                int dimension3 = (int) pageActivity.getResources().getDimension(R.dimen.ds32);
                int dimension4 = (int) pageActivity.getResources().getDimension(R.dimen.ds106);
                int dimension5 = (int) pageActivity.getResources().getDimension(R.dimen.ds52);
                CountDownTextView countDownTextView = new CountDownTextView(pageActivity);
                this.eCC = new C0443a(countDownTextView);
                String str = this.eCD;
                if (TextUtils.isEmpty(str)) {
                    str = pageActivity.getResources().getString(R.string.skip);
                }
                if (splashAdView.eDl) {
                    countDownTextView.au(str, 6);
                } else {
                    countDownTextView.au(str, 3);
                }
                splashAdView.setTag(Boolean.valueOf(splashAdView.eDl));
                countDownTextView.setTextSize(0, dimension);
                countDownTextView.setTextColor(Color.parseColor("#ffffff"));
                countDownTextView.setGravity(17);
                countDownTextView.setAlpha(0.5f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#000000"));
                gradientDrawable.setCornerRadius(pageActivity.getResources().getDimension(R.dimen.ds4));
                gradientDrawable.setStroke(1, Color.parseColor("#000000"));
                countDownTextView.setBackgroundDrawable(gradientDrawable);
                countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.a.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                    }
                });
                countDownTextView.setTimeoutListener(new CountDownTextView.b() { // from class: com.baidu.tieba.advert.sdk.a.4
                    @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.b
                    public void br(View view) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://timeout"));
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimension4, dimension5);
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.setMargins(0, statusBarHeight, dimension3, 0);
                int dimens = l.getDimens(pageActivity, R.dimen.ds9);
                countDownTextView.setPadding(dimens, dimens, dimens, dimens);
                splashAdView.addView(countDownTextView, layoutParams);
                int dimension6 = (int) pageActivity.getResources().getDimension(R.dimen.ds28);
                TextView textView = new TextView(pageActivity);
                textView.setText(R.string.advert_label);
                textView.setTextSize(0, dimension);
                textView.setAlpha(0.5f);
                textView.setIncludeFontPadding(false);
                textView.setGravity(17);
                textView.setBackgroundDrawable(gradientDrawable.getConstantState().newDrawable());
                int dimens2 = l.getDimens(pageActivity, R.dimen.ds2);
                textView.setPadding(dimens2, dimens2, dimens2, dimens2);
                am.setViewTextColor(textView, (int) R.color.common_color_10013);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) pageActivity.getResources().getDimension(R.dimen.ds68), (int) pageActivity.getResources().getDimension(R.dimen.ds40));
                layoutParams2.setMargins(dimension6, 0, 0, dimension6);
                layoutParams2.addRule(9);
                layoutParams2.addRule(12);
                splashAdView.addView(textView, layoutParams2);
                return splashAdView;
            } catch (Exception e) {
                return splashAdView;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK(String str) {
        if (this.eCC != null && !TextUtils.isEmpty(str)) {
            this.eCC.yM(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.advert.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0443a {
        private final WeakReference<CountDownTextView> eCH;

        private C0443a(CountDownTextView countDownTextView) {
            this.eCH = new WeakReference<>(countDownTextView);
        }

        public void yM(String str) {
            CountDownTextView countDownTextView = this.eCH.get();
            if (countDownTextView != null) {
                countDownTextView.au(str, 0);
            }
        }
    }
}
