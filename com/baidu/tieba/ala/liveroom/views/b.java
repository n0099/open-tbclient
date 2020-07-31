package com.baidu.tieba.ala.liveroom.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.text.ClipboardManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.live.liveroom.middleware.a.a {
    private TextView aRC;
    private int fFX;
    private HeadImageView fGy;
    private TextView gyA;
    private FrameLayout gyB;
    private TextView gyC;
    private FrameLayout gyD;
    private TbImageView gyE;
    private TextView gyF;
    private TextView gyG;
    private RelativeLayout gyH;
    private LinearLayout gyI;
    private TextView gyJ;
    private TextView gyK;
    private String gyN;
    private com.baidu.live.liveroom.middleware.a.e gyo;
    private RelativeLayout gyp;
    private ImageView gyq;
    private TextView gyr;
    private LinearLayout gys;
    private LinearLayout gyt;
    private TextView gyu;
    private TextView gyv;
    private TextView gyw;
    private TextView gyx;
    private TextView gyy;
    private TextView gyz;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean gyL = false;
    private boolean gyM = false;
    private String fYn = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void r(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(q qVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.fFX = i;
        this.fYn = str;
        this.gyo = eVar;
        d(qVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(q qVar, String str) {
        d(qVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_end_view_layout, (ViewGroup) null);
        this.gyp = (RelativeLayout) this.rootView.findViewById(a.g.inner_layout);
        this.gyq = (ImageView) this.rootView.findViewById(a.g.imgClose);
        this.fGy = (HeadImageView) this.rootView.findViewById(a.g.avatar_imageView);
        this.gyr = (TextView) this.rootView.findViewById(a.g.username_textView);
        this.gys = (LinearLayout) this.rootView.findViewById(a.g.endTitle_layout);
        this.gyt = (LinearLayout) this.rootView.findViewById(a.g.achievement_layout);
        this.aRC = (TextView) this.rootView.findViewById(a.g.title_textView);
        this.gyu = (TextView) this.rootView.findViewById(a.g.tvLiveEndTitle);
        this.gyv = (TextView) this.rootView.findViewById(a.g.tvLiveEndSubTitle);
        this.gyw = (TextView) this.rootView.findViewById(a.g.tvLiveEndUseTime);
        this.gyx = (TextView) this.rootView.findViewById(a.g.tvLiveEndWatchNum);
        this.gyy = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewFansNum);
        this.gyz = (TextView) this.rootView.findViewById(a.g.tvLiveEndGiverNum);
        this.gyA = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewCharmNum);
        this.gyB = (FrameLayout) this.rootView.findViewById(a.g.share_layout);
        this.gyC = (TextView) this.rootView.findViewById(a.g.share_textView);
        this.gyD = (FrameLayout) this.rootView.findViewById(a.g.qr_layout);
        this.gyE = (TbImageView) this.rootView.findViewById(a.g.qr_imageView);
        this.gyF = (TextView) this.rootView.findViewById(a.g.appName_textView);
        this.gyG = (TextView) this.rootView.findViewById(a.g.qrIntroduce_textView);
        this.gyH = (RelativeLayout) this.rootView.findViewById(a.g.userHead_layout);
        this.gyI = (LinearLayout) this.rootView.findViewById(a.g.official_qq_group_ll);
        this.gyJ = (TextView) this.rootView.findViewById(a.g.official_qq_group);
        this.gyK = (TextView) this.rootView.findViewById(a.g.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gys.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gyq.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.gyq.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gyH.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.gyH.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(q qVar, String str) {
        final String str2;
        if (qVar != null && qVar.mLiveInfo != null) {
            this.mLiveInfo = qVar.mLiveInfo;
            this.fGy.setIsRound(true);
            this.fGy.setDrawBorder(true);
            this.fGy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fGy.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.fGy.setDefaultResource(a.f.pic_avatar_moren);
            } else {
                this.fGy.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.gyr.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = qVar.mLiveInfo.anchorTitle;
            this.aRC.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.gyu.setText(this.mContext.getResources().getString(a.i.live_over_name));
            if (!TextUtils.isEmpty(this.fYn)) {
                SkinManager.setViewTextColor(this.gyv, a.d.sdk_hk_gradient_color_start);
                this.gyv.setAlpha(0.7f);
                this.gyv.setText(this.fYn);
                this.gyv.setVisibility(0);
            } else if (this.fFX == 1) {
                SkinManager.setViewTextColor(this.gyv, a.d.sdk_hk_gradient_color_start);
                this.gyv.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.gyv.setText(closeReason);
                this.gyv.setVisibility(0);
                this.gyu.setText(this.mContext.getResources().getString(a.i.live_closed));
            } else if (this.fFX == 0) {
                this.gyv.setVisibility(8);
            }
            this.gyw.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.gyx.setText(i.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.gyx.setText(i.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.gyy.setText(i.formatTosepara(this.mLiveInfo.newFansCount));
            this.gyz.setText(i.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.gyA.setText(i.formatTosepara(this.mLiveInfo.charm_count));
            this.gyq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.gyo != null) {
                        b.this.gyo.FE();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gyC.setBackgroundResource(a.f.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.gyC.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.gyC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
                /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
                @Override // android.view.View.OnClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onClick(View view) {
                    boolean z;
                    File file;
                    LogManager.getLiveCloseLogger().doClickShowOffLiveCloseLog(str4, str5, str2, b.this.otherParams);
                    if (b.this.gyo != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.gyL;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.gyN) && (file = new File(b.this.gyN)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.gyM != z2) {
                                    b.this.gyN = b.this.mc(z2);
                                }
                                if (z2) {
                                    b.this.gyM = true;
                                }
                                if (TextUtils.isEmpty(b.this.gyN)) {
                                    b.this.gyo.fB(b.this.gyN);
                                    return;
                                } else {
                                    BdUtilHelper.getCustomToast().showToast("分享失败", 0);
                                    return;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                        b.this.gyN = b.this.mc(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.gyN)) {
                        }
                    }
                }
            });
            this.gyE.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.gyL = z;
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            String str6 = "";
            if (TbadkCoreApplication.getInst().isHaokan()) {
                str6 = "好看视频";
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                str6 = "全民小视频";
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                str6 = "百度贴吧";
            }
            this.gyF.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.gyG.setText("长按二维码认识 " + nameShow);
            if (bMZ()) {
                this.gyI.setVisibility(0);
                this.gyJ.setText(this.mContext.getResources().getString(a.i.ala_live_end_official_qq_group) + " " + com.baidu.live.v.a.Hs().aZn.aCa.ayJ);
                this.gyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.v.a.Hs().aZn.aCa.ayJ);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.i.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.gyI.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.gyE.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        }
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onResume() {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onPause() {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void bU(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean bMZ() {
        return (com.baidu.live.v.a.Hs().aZn == null || com.baidu.live.v.a.Hs().aZn.aCa == null || TextUtils.isEmpty(com.baidu.live.v.a.Hs().aZn.aCa.ayJ)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyToClipboard(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public String mc(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.gyp;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.gyq.setVisibility(8);
        this.gys.setVisibility(8);
        this.gyt.setVisibility(0);
        this.gyB.setVisibility(8);
        this.gyI.setVisibility(8);
        if (z) {
            this.gyD.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.gyq.setVisibility(0);
        this.gys.setVisibility(0);
        this.gyt.setVisibility(4);
        this.gyB.setVisibility(0);
        if (bMZ()) {
            this.gyI.setVisibility(0);
        }
        this.gyD.setAlpha(0.0f);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            str = "haokan";
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            str = TbadkCoreApplication.APP_ID_QUANMIN;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            str = "tieba";
        } else {
            str = "baidu";
        }
        if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.isDirectory()) {
            str2 = externalStoragePublicDirectory.getPath() + "/" + str + "/live/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        } else if ("mounted".equals(Environment.getExternalStorageState())) {
            File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + str + "/live/");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            str2 = file2.getPath();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = this.mContext.getCacheDir().getPath();
        }
        Log.i("AlaLiveEndView", "@@ path=" + str2);
        File file3 = new File(str2, charSequence);
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                String path = file3.getPath();
                Log.i("AlaLiveEndView", "@@ fullPath=" + path);
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.parse("file://" + path));
                this.mContext.sendBroadcast(intent);
                if (createBitmap != null) {
                    try {
                        createBitmap.recycle();
                        return path;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return path;
                    }
                }
                return path;
            } catch (Throwable th) {
                if (createBitmap != null) {
                    try {
                        createBitmap.recycle();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            if (createBitmap != null) {
                try {
                    createBitmap.recycle();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        }
    }
}
