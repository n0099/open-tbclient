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
import com.baidu.live.data.w;
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
import com.baidu.live.utils.j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class b extends com.baidu.live.liveroom.middleware.a.a {
    private TextView bdT;
    private int gqZ;
    private HeadImageView grA;
    private TextView hoA;
    private TextView hoB;
    private TextView hoC;
    private TextView hoD;
    private TextView hoE;
    private TextView hoF;
    private TextView hoG;
    private FrameLayout hoH;
    private TextView hoI;
    private FrameLayout hoJ;
    private TbImageView hoK;
    private TextView hoL;
    private TextView hoM;
    private RelativeLayout hoN;
    private LinearLayout hoO;
    private TextView hoP;
    private TextView hoQ;
    private String hoT;
    private com.baidu.live.liveroom.middleware.a.e hou;
    private RelativeLayout hov;
    private ImageView how;
    private TextView hox;
    private LinearLayout hoy;
    private LinearLayout hoz;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean hoR = false;
    private boolean hoS = false;
    private String gND = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void s(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(w wVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.gqZ = i;
        this.gND = str;
        this.hou = eVar;
        d(wVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(w wVar, String str) {
        d(wVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_end_view_layout, (ViewGroup) null);
        this.hov = (RelativeLayout) this.rootView.findViewById(a.g.inner_layout);
        this.how = (ImageView) this.rootView.findViewById(a.g.imgClose);
        this.grA = (HeadImageView) this.rootView.findViewById(a.g.avatar_imageView);
        this.hox = (TextView) this.rootView.findViewById(a.g.username_textView);
        this.hoy = (LinearLayout) this.rootView.findViewById(a.g.endTitle_layout);
        this.hoz = (LinearLayout) this.rootView.findViewById(a.g.achievement_layout);
        this.bdT = (TextView) this.rootView.findViewById(a.g.title_textView);
        this.hoA = (TextView) this.rootView.findViewById(a.g.tvLiveEndTitle);
        this.hoB = (TextView) this.rootView.findViewById(a.g.tvLiveEndSubTitle);
        this.hoC = (TextView) this.rootView.findViewById(a.g.tvLiveEndUseTime);
        this.hoD = (TextView) this.rootView.findViewById(a.g.tvLiveEndWatchNum);
        this.hoE = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewFansNum);
        this.hoF = (TextView) this.rootView.findViewById(a.g.tvLiveEndGiverNum);
        this.hoG = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewCharmNum);
        this.hoH = (FrameLayout) this.rootView.findViewById(a.g.share_layout);
        this.hoI = (TextView) this.rootView.findViewById(a.g.share_textView);
        this.hoJ = (FrameLayout) this.rootView.findViewById(a.g.qr_layout);
        this.hoK = (TbImageView) this.rootView.findViewById(a.g.qr_imageView);
        this.hoL = (TextView) this.rootView.findViewById(a.g.appName_textView);
        this.hoM = (TextView) this.rootView.findViewById(a.g.qrIntroduce_textView);
        this.hoN = (RelativeLayout) this.rootView.findViewById(a.g.userHead_layout);
        this.hoO = (LinearLayout) this.rootView.findViewById(a.g.official_qq_group_ll);
        this.hoP = (TextView) this.rootView.findViewById(a.g.official_qq_group);
        this.hoQ = (TextView) this.rootView.findViewById(a.g.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hoy.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.how.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.how.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hoN.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.hoN.setLayoutParams(layoutParams2);
            }
        }
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    private void d(w wVar, String str) {
        final String str2;
        if (wVar != null && wVar.mLiveInfo != null) {
            this.mLiveInfo = wVar.mLiveInfo;
            this.grA.setIsRound(true);
            this.grA.setDrawBorder(true);
            this.grA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.grA.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.grA.setDefaultResource(a.f.pic_avatar_moren);
            } else if (!TextUtils.equals(this.grA.getUrl(), this.mPortrait)) {
                this.grA.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.hox.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = wVar.mLiveInfo.anchorTitle;
            this.bdT.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.hoA.setText(this.mContext.getResources().getString(a.i.live_over_name));
            if (!TextUtils.isEmpty(this.gND)) {
                SkinManager.setViewTextColor(this.hoB, a.d.sdk_hk_gradient_color_start);
                this.hoB.setAlpha(0.7f);
                this.hoB.setText(this.gND);
                this.hoB.setVisibility(0);
            } else if (this.gqZ == 1) {
                SkinManager.setViewTextColor(this.hoB, a.d.sdk_hk_gradient_color_start);
                this.hoB.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.hoB.setText(closeReason);
                this.hoB.setVisibility(0);
                this.hoA.setText(this.mContext.getResources().getString(a.i.live_closed));
            } else if (this.gqZ == 0) {
                this.hoB.setVisibility(8);
            }
            this.hoC.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.hoD.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.hoD.setText(j.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.hoE.setText(j.formatTosepara(this.mLiveInfo.newFansCount));
            this.hoF.setText(j.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.hoG.setText(j.formatTosepara(this.mLiveInfo.charm_count));
            this.how.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hou != null) {
                        b.this.hou.Nm();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hoI.setBackgroundResource(a.f.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.hoI.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.hoI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.hou != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.hoR;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.hoT) && (file = new File(b.this.hoT)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.hoS != z2) {
                                    b.this.hoT = b.this.nD(z2);
                                }
                                if (z2) {
                                    b.this.hoS = true;
                                }
                                if (TextUtils.isEmpty(b.this.hoT)) {
                                    b.this.hou.hI(b.this.hoT);
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
                        b.this.hoT = b.this.nD(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.hoT)) {
                        }
                    }
                }
            });
            this.hoK.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.hoR = z;
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
            } else if (TbadkCoreApplication.getInst().isYinbo()) {
                str6 = "音啵";
            }
            this.hoL.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.hoM.setText("长按二维码认识 " + nameShow);
            if (cfi()) {
                this.hoO.setVisibility(0);
                this.hoP.setText(this.mContext.getResources().getString(a.i.ala_live_end_official_qq_group) + " " + com.baidu.live.z.a.Pq().bmJ.aMl.aIo);
                this.hoQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.z.a.Pq().bmJ.aMl.aIo);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.i.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.hoO.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.hoK.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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
    public void cg(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean cfi() {
        return (com.baidu.live.z.a.Pq().bmJ == null || com.baidu.live.z.a.Pq().bmJ.aMl == null || TextUtils.isEmpty(com.baidu.live.z.a.Pq().bmJ.aMl.aIo)) ? false : true;
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
    public String nD(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.hov;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.how.setVisibility(8);
        this.hoy.setVisibility(8);
        this.hoz.setVisibility(0);
        this.hoH.setVisibility(8);
        this.hoO.setVisibility(8);
        if (z) {
            this.hoJ.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.how.setVisibility(0);
        this.hoy.setVisibility(0);
        this.hoz.setVisibility(4);
        this.hoH.setVisibility(0);
        if (cfi()) {
            this.hoO.setVisibility(0);
        }
        this.hoJ.setAlpha(0.0f);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            str = "haokan";
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            str = TbadkCoreApplication.APP_ID_QUANMIN;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            str = "tieba";
        } else if (TbadkCoreApplication.getInst().isYinbo()) {
            str = TbadkCoreApplication.APP_ID_YINBO;
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
            } catch (IOException e2) {
                e2.printStackTrace();
                if (createBitmap != null) {
                    try {
                        createBitmap.recycle();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            if (createBitmap != null) {
                try {
                    createBitmap.recycle();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
