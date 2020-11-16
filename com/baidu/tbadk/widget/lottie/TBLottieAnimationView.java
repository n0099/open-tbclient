package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.e;
import com.airbnb.lottie.i;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.lottie.b;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    public static final String INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private b fFP;
    private boolean fFQ;
    private b.a fFR;
    private boolean isFirstLoadInternal;
    private boolean isSettingForPlay;
    private String mUrl;

    public TBLottieAnimationView(Context context) {
        super(context);
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.fFQ = false;
        this.fFR = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void onLoaded(boolean z, String str) {
                if (z && !au.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.fFQ = false;
        this.fFR = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void onLoaded(boolean z, String str) {
                if (z && !au.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.fFQ = false;
        this.fFR = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void onLoaded(boolean z, String str) {
                if (z && !au.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str);
                }
            }
        };
    }

    public static String getAnimationPath() {
        return INTERNEL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean checkInternalTempDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.join("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public static InputStream getAnimationInputStream(String str, String str2) {
        String animationPath = getAnimationPath();
        if (checkInternalTempDir(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.getInStreamFromFile(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void setAnimationUrl(String str) {
        if (!au.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.fFP = new b(getAnimationPath(), str, this.fFR);
            this.fFP.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str) {
        if (!au.isEmpty(str)) {
            dealImageAsset(str);
            dealJsonFile(str);
        }
    }

    private void dealImageAsset(String str) {
        if (!au.isEmpty(str)) {
            a aVar = new a();
            aVar.setPath(str);
            aVar.setFirstLoadInternal(getFristLoadInternal());
            setImageAssetDelegate(aVar);
        }
    }

    private void dealJsonFile(String str) {
        if (!au.isEmpty(str)) {
            final boolean z = this.isSettingForPlay;
            cancelAnimation();
            InputStream animationInputStream = getAnimationInputStream(str, com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.JSON_FILE);
            if (animationInputStream != null) {
                com.airbnb.lottie.f.b(animationInputStream, str).a(new i<e>() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.airbnb.lottie.i
                    public void onResult(e eVar) {
                        if (eVar != null) {
                            TBLottieAnimationView.this.setComposition(eVar);
                            if (z) {
                                TBLottieAnimationView.this.playAnimation();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(@NonNull e eVar) {
        super.setComposition(eVar);
        if (this.isSettingForPlay) {
            playAnimation();
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        super.playAnimation();
        this.isSettingForPlay = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        super.pauseAnimation();
        this.isSettingForPlay = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.isSettingForPlay = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        super.resumeAnimation();
        this.isSettingForPlay = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.isFirstLoadInternal = z;
    }

    public boolean getFristLoadInternal() {
        return this.isFirstLoadInternal;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.fFQ) {
            super.onRestoreInstanceState(parcelable);
        }
        this.fFQ = false;
    }

    public void bER() {
        this.fFQ = true;
    }
}
