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
    private TextView bfp;
    private int gwN;
    private HeadImageView gxo;
    private TextView huA;
    private TextView huB;
    private TextView huC;
    private TextView huD;
    private TextView huE;
    private FrameLayout huF;
    private TextView huG;
    private FrameLayout huH;
    private TbImageView huI;
    private TextView huJ;
    private TextView huK;
    private RelativeLayout huL;
    private LinearLayout huM;
    private TextView huN;
    private TextView huO;
    private String huR;
    private com.baidu.live.liveroom.middleware.a.e hus;
    private RelativeLayout hut;
    private ImageView huu;
    private TextView huv;
    private LinearLayout huw;
    private LinearLayout hux;
    private TextView huy;
    private TextView huz;
    private Context mContext;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private View rootView;
    private boolean huP = false;
    private boolean huQ = false;
    private String gUc = null;
    private String otherParams = "";

    @Override // com.baidu.live.liveroom.middleware.i
    public void s(Activity activity) {
        this.mContext = activity;
        initUI();
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(w wVar, com.baidu.live.liveroom.middleware.a.e eVar, int i, String str, String str2, String str3) {
        this.mPortrait = str2;
        this.gwN = i;
        this.gUc = str;
        this.hus = eVar;
        d(wVar, str3);
        return this.rootView;
    }

    @Override // com.baidu.live.liveroom.middleware.a.b
    public View a(w wVar, String str) {
        d(wVar, str);
        return this.rootView;
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_live_end_view_layout, (ViewGroup) null);
        this.hut = (RelativeLayout) this.rootView.findViewById(a.f.inner_layout);
        this.huu = (ImageView) this.rootView.findViewById(a.f.imgClose);
        this.gxo = (HeadImageView) this.rootView.findViewById(a.f.avatar_imageView);
        this.huv = (TextView) this.rootView.findViewById(a.f.username_textView);
        this.huw = (LinearLayout) this.rootView.findViewById(a.f.endTitle_layout);
        this.hux = (LinearLayout) this.rootView.findViewById(a.f.achievement_layout);
        this.bfp = (TextView) this.rootView.findViewById(a.f.title_textView);
        this.huy = (TextView) this.rootView.findViewById(a.f.tvLiveEndTitle);
        this.huz = (TextView) this.rootView.findViewById(a.f.tvLiveEndSubTitle);
        this.huA = (TextView) this.rootView.findViewById(a.f.tvLiveEndUseTime);
        this.huB = (TextView) this.rootView.findViewById(a.f.tvLiveEndWatchNum);
        this.huC = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewFansNum);
        this.huD = (TextView) this.rootView.findViewById(a.f.tvLiveEndGiverNum);
        this.huE = (TextView) this.rootView.findViewById(a.f.tvLiveEndNewCharmNum);
        this.huF = (FrameLayout) this.rootView.findViewById(a.f.share_layout);
        this.huG = (TextView) this.rootView.findViewById(a.f.share_textView);
        this.huH = (FrameLayout) this.rootView.findViewById(a.f.qr_layout);
        this.huI = (TbImageView) this.rootView.findViewById(a.f.qr_imageView);
        this.huJ = (TextView) this.rootView.findViewById(a.f.appName_textView);
        this.huK = (TextView) this.rootView.findViewById(a.f.qrIntroduce_textView);
        this.huL = (RelativeLayout) this.rootView.findViewById(a.f.userHead_layout);
        this.huM = (LinearLayout) this.rootView.findViewById(a.f.official_qq_group_ll);
        this.huN = (TextView) this.rootView.findViewById(a.f.official_qq_group);
        this.huO = (TextView) this.rootView.findViewById(a.f.copy_official_qq_group);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.huw.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.huu.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.huu.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.huL.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.huL.setLayoutParams(layoutParams2);
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
            this.gxo.setIsRound(true);
            this.gxo.setDrawBorder(true);
            this.gxo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gxo.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gxo.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.gxo.setDefaultResource(a.e.pic_avatar_moren);
            } else if (!TextUtils.equals(this.gxo.getUrl(), this.mPortrait)) {
                this.gxo.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.huv.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = wVar.mLiveInfo.anchorTitle;
            this.bfp.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.huy.setText(this.mContext.getResources().getString(a.h.live_over_name));
            if (!TextUtils.isEmpty(this.gUc)) {
                SkinManager.setViewTextColor(this.huz, a.c.sdk_hk_gradient_color_start);
                this.huz.setAlpha(0.7f);
                this.huz.setText(this.gUc);
                this.huz.setVisibility(0);
            } else if (this.gwN == 1) {
                SkinManager.setViewTextColor(this.huz, a.c.sdk_hk_gradient_color_start);
                this.huz.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.huz.setText(closeReason);
                this.huz.setVisibility(0);
                this.huy.setText(this.mContext.getResources().getString(a.h.live_closed));
            } else if (this.gwN == 0) {
                this.huz.setVisibility(8);
            }
            this.huA.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.huB.setText(j.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.huB.setText(j.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.huC.setText(j.formatTosepara(this.mLiveInfo.newFansCount));
            this.huD.setText(j.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.huE.setText(j.formatTosepara(this.mLiveInfo.charm_count));
            this.huu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.hus != null) {
                        b.this.hus.NM();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.huG.setBackgroundResource(a.e.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.huG.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.huG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.2
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
                    if (b.this.hus != null) {
                        boolean z2 = !TextUtils.isEmpty(b.this.mLiveInfo.qrcodeDownloadUrl) && b.this.huP;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(b.this.huR) && (file = new File(b.this.huR)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || b.this.huQ != z2) {
                                    b.this.huR = b.this.nM(z2);
                                }
                                if (z2) {
                                    b.this.huQ = true;
                                }
                                if (TextUtils.isEmpty(b.this.huR)) {
                                    b.this.hus.hP(b.this.huR);
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
                        b.this.huR = b.this.nM(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(b.this.huR)) {
                        }
                    }
                }
            });
            this.huI.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.b.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, b.this.mLiveInfo.qrcodeDownloadUrl)) {
                        b.this.huP = z;
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
            this.huJ.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.huK.setText("长按二维码认识 " + nameShow);
            if (chL()) {
                this.huM.setVisibility(0);
                this.huN.setText(this.mContext.getResources().getString(a.h.ala_live_end_official_qq_group) + " " + com.baidu.live.aa.a.PQ().bod.aNl.aJf);
                this.huO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.b.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        b.this.copyToClipboard(com.baidu.live.aa.a.PQ().bod.aNl.aJf);
                        BdToast.makeText(b.this.mContext, b.this.mContext.getResources().getString(a.h.ala_live_end_copy_qq_to_clipboard)).setDuration(17).show();
                    }
                });
            } else {
                this.huM.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.huI.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
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
    public void ch(boolean z) {
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.baidu.live.liveroom.middleware.i
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    private boolean chL() {
        return (com.baidu.live.aa.a.PQ().bod == null || com.baidu.live.aa.a.PQ().bod.aNl == null || TextUtils.isEmpty(com.baidu.live.aa.a.PQ().bod.aNl.aJf)) ? false : true;
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
    public String nM(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.hut;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.huu.setVisibility(8);
        this.huw.setVisibility(8);
        this.hux.setVisibility(0);
        this.huF.setVisibility(8);
        this.huM.setVisibility(8);
        if (z) {
            this.huH.setAlpha(1.0f);
        }
        relativeLayout.draw(canvas);
        this.huu.setVisibility(0);
        this.huw.setVisibility(0);
        this.hux.setVisibility(4);
        this.huF.setVisibility(0);
        if (chL()) {
            this.huM.setVisibility(0);
        }
        this.huH.setAlpha(0.0f);
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
