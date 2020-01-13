package com.baidu.tieba.ala.liveroom.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.BuildConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes2.dex */
public class c {
    private TextView dwR;
    private HeadImageView eCl;
    private String eKw;
    private a fiP;
    private RelativeLayout fiQ;
    private TbImageView fiR;
    private ImageView fiS;
    private TextView fiT;
    private LinearLayout fiU;
    private LinearLayout fiV;
    private TextView fiW;
    private TextView fiX;
    private TextView fiY;
    private TextView fiZ;
    private TextView fja;
    private TextView fjb;
    private TextView fjc;
    private FrameLayout fjd;
    private TextView fje;
    private FrameLayout fjf;
    private TbImageView fjg;
    private TextView fjh;
    private TextView fji;
    private RelativeLayout fjj;
    private String fjm;
    private Context mContext;
    private int mFromType;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private String nickName;
    private View rootView;
    private boolean fjk = false;
    private boolean fjl = false;
    private String otherParams = "";

    /* loaded from: classes2.dex */
    public interface a {
        void bco();

        void yo(String str);
    }

    public c(Context context, AlaLiveInfoData alaLiveInfoData, a aVar, int i, String str, String str2, String str3) {
        this.eKw = null;
        this.mContext = context;
        this.mLiveInfo = alaLiveInfoData;
        this.fiP = aVar;
        this.mFromType = i;
        this.eKw = str;
        this.mPortrait = str2;
        this.nickName = str3;
        initUI();
        if (alaLiveInfoData.live_type == 1) {
        }
    }

    private void initUI() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_live_end_view_layout, (ViewGroup) null);
        this.fiQ = (RelativeLayout) this.rootView.findViewById(a.g.inner_layout);
        this.fiR = (TbImageView) this.rootView.findViewById(a.g.rlLiveOverRoot);
        this.fiS = (ImageView) this.rootView.findViewById(a.g.imgClose);
        this.eCl = (HeadImageView) this.rootView.findViewById(a.g.avatar_imageView);
        this.fiT = (TextView) this.rootView.findViewById(a.g.username_textView);
        this.fiU = (LinearLayout) this.rootView.findViewById(a.g.endTitle_layout);
        this.fiV = (LinearLayout) this.rootView.findViewById(a.g.achievement_layout);
        this.dwR = (TextView) this.rootView.findViewById(a.g.title_textView);
        this.fiW = (TextView) this.rootView.findViewById(a.g.tvLiveEndTitle);
        this.fiX = (TextView) this.rootView.findViewById(a.g.tvLiveEndSubTitle);
        this.fiY = (TextView) this.rootView.findViewById(a.g.tvLiveEndUseTime);
        this.fiZ = (TextView) this.rootView.findViewById(a.g.tvLiveEndWatchNum);
        this.fja = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewFansNum);
        this.fjb = (TextView) this.rootView.findViewById(a.g.tvLiveEndGiverNum);
        this.fjc = (TextView) this.rootView.findViewById(a.g.tvLiveEndNewCharmNum);
        this.fjd = (FrameLayout) this.rootView.findViewById(a.g.share_layout);
        this.fje = (TextView) this.rootView.findViewById(a.g.share_textView);
        this.fjf = (FrameLayout) this.rootView.findViewById(a.g.qr_layout);
        this.fjg = (TbImageView) this.rootView.findViewById(a.g.qr_imageView);
        this.fjh = (TextView) this.rootView.findViewById(a.g.appName_textView);
        this.fji = (TextView) this.rootView.findViewById(a.g.qrIntroduce_textView);
        this.fjj = (RelativeLayout) this.rootView.findViewById(a.g.userHead_layout);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fiU.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiS.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
                this.fiS.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fjj.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.topMargin += UtilHelper.getStatusBarHeight();
                this.fjj.setLayoutParams(layoutParams2);
            }
        }
        b(this.mLiveInfo, this.nickName);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_BEGIN);
            alaStaticItem.addParams("start_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.ACCESS_MASTER_CLOSE_LIVE));
        }
    }

    public void a(AlaLiveInfoData alaLiveInfoData, String str) {
        b(alaLiveInfoData, str);
    }

    private void b(AlaLiveInfoData alaLiveInfoData, String str) {
        final String str2;
        if (alaLiveInfoData != null) {
            this.mLiveInfo = alaLiveInfoData;
            if (!TextUtils.isEmpty(this.mLiveInfo.cover)) {
                this.fiR.startLoad(this.mLiveInfo.cover, 39, false);
            }
            this.fiQ.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.views.c.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams = c.this.fiR.getLayoutParams();
                    layoutParams.height = c.this.fiQ.getHeight();
                    c.this.fiR.setLayoutParams(layoutParams);
                }
            });
            this.eCl.setIsRound(true);
            this.eCl.setDrawBorder(true);
            this.eCl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.eCl.setAutoChangeStyle(false);
            if (TextUtils.isEmpty(this.mPortrait)) {
                this.eCl.setDefaultResource(a.f.pic_avatar_moren);
            } else {
                this.eCl.startLoad(this.mPortrait, 12, false, false);
            }
            if (TextUtils.isEmpty(str) || "null".equals(str)) {
                str = this.mLiveInfo.getNameShow();
            }
            if (!TextUtils.isEmpty(str) && str.length() > 10) {
                str = str.substring(0, 8) + StringHelper.STRING_MORE;
            }
            this.fiT.setText(Html.fromHtml(String.format("亲爱的<font color='#fed500'>%s</font>，本次直播荣获称号", str)));
            String str3 = alaLiveInfoData.anchorTitle;
            this.dwR.setText((TextUtils.isEmpty(str3) || TextUtils.equals(str3, "null")) ? "" : "");
            this.fiW.setText(this.mContext.getResources().getString(a.i.live_over_name));
            if (!TextUtils.isEmpty(this.eKw)) {
                SkinManager.setViewTextColor(this.fiX, a.d.sdk_hk_gradient_color_start);
                this.fiX.setAlpha(0.7f);
                this.fiX.setText(this.eKw);
                this.fiX.setVisibility(0);
            } else if (this.mFromType == 1) {
                SkinManager.setViewTextColor(this.fiX, a.d.sdk_hk_gradient_color_start);
                this.fiX.setAlpha(0.7f);
                String closeReason = this.mLiveInfo.getCloseReason();
                if (TextUtils.equals(closeReason, "0")) {
                    closeReason = "";
                }
                this.fiX.setText(closeReason);
                this.fiX.setVisibility(0);
                this.fiW.setText(this.mContext.getResources().getString(a.i.live_closed));
            } else if (this.mFromType == 0) {
                this.fiX.setVisibility(8);
            }
            this.fiY.setText(StringUtils.translateSecondsToString2((int) this.mLiveInfo.getLiveDuration()));
            if (this.mLiveInfo.familyFansCount > 10000) {
                this.fiZ.setText(i.numFormatOverWanNaForAudienceNum(this.mLiveInfo.familyFansCount));
            } else {
                this.fiZ.setText(i.formatTosepara(this.mLiveInfo.familyFansCount));
            }
            this.fja.setText(i.formatTosepara(this.mLiveInfo.newFansCount));
            this.fjb.setText(i.formatTosepara(this.mLiveInfo.rewardUserCount));
            this.fjc.setText(i.formatTosepara(this.mLiveInfo.charm_count));
            this.fiS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.fiP != null) {
                        c.this.fiP.bco();
                    }
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fje.setBackgroundResource(a.f.round_sharebtn_hk_bg_radius_12_n);
            } else {
                this.fje.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_40_n);
            }
            final String str4 = this.mLiveInfo.live_id + "";
            final String str5 = this.mLiveInfo.room_id + "";
            if (this.mLiveInfo.feed_id == null || TextUtils.equals(this.mLiveInfo.feed_id, "null")) {
                str2 = "";
            } else {
                str2 = this.mLiveInfo.feed_id;
            }
            this.fje.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.views.c.3
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
                    LogManager.getLiveCloseLogger().doClickShowOffLiveCloseLog(str4, str5, str2, c.this.otherParams);
                    if (c.this.fiP != null) {
                        boolean z2 = !TextUtils.isEmpty(c.this.mLiveInfo.qrcodeDownloadUrl) && c.this.fjk;
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(c.this.fjm) && (file = new File(c.this.fjm)) != null && file.exists()) {
                            if (file.isFile()) {
                                z = true;
                                if (z || c.this.fjl != z2) {
                                    c.this.fjm = c.this.jL(z2);
                                }
                                if (z2) {
                                    c.this.fjl = true;
                                }
                                if (TextUtils.isEmpty(c.this.fjm)) {
                                    c.this.fiP.yo(c.this.fjm);
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
                        c.this.fjm = c.this.jL(z2);
                        if (z2) {
                        }
                        if (TextUtils.isEmpty(c.this.fjm)) {
                        }
                    }
                }
            });
            this.fjg.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.views.c.4
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str6, boolean z) {
                    if (TextUtils.equals(str6, c.this.mLiveInfo.qrcodeDownloadUrl)) {
                        c.this.fjk = z;
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
            this.fjh.setText(str6);
            String nameShow = this.mLiveInfo.getNameShow();
            if (nameShow == null) {
                nameShow = "";
            }
            this.fji.setText("长按二维码认识 " + nameShow);
            if (!TextUtils.isEmpty(this.mLiveInfo.qrcodeDownloadUrl)) {
                this.fjg.startLoad(this.mLiveInfo.qrcodeDownloadUrl, 10, false);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        }
    }

    public void onDestory() {
    }

    public View getRootView() {
        return this.rootView;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public String jL(boolean z) {
        String str;
        String str2;
        RelativeLayout relativeLayout = this.fiQ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Calendar.getInstance().add(5, 0);
        String charSequence = TextUtils.concat("screenshot_", simpleDateFormat.format(new Date()), ".jpg").toString();
        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.fiS.setVisibility(8);
        this.fiU.setVisibility(8);
        this.fiV.setVisibility(0);
        this.fjd.setVisibility(8);
        if (z) {
            this.fjf.setVisibility(0);
        }
        relativeLayout.draw(canvas);
        this.fiS.setVisibility(0);
        this.fiU.setVisibility(0);
        this.fiV.setVisibility(4);
        this.fjd.setVisibility(0);
        this.fjf.setVisibility(4);
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            str = TbadkCoreApplication.APP_ID_HAOKAN;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            str = TbadkCoreApplication.APP_ID_QUANMIN;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            str = "tieba";
        } else {
            str = BuildConfig.FLAVOR;
        }
        if (externalStoragePublicDirectory != null && externalStoragePublicDirectory.isDirectory()) {
            str2 = externalStoragePublicDirectory.getPath() + "/" + str + "/live/";
            File file = new File(str2);
            if (file == null || !file.exists()) {
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
