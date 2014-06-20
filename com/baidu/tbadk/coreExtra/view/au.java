package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
public class au extends RelativeLayout {
    protected ProgressBar a;
    protected com.baidu.tbadk.widget.a b;
    protected Context c;
    private aw d;
    private av e;
    private boolean f;

    public void setHeadImage(boolean z) {
        if (this.b != null) {
            this.b.setIsHeadImage(z);
        }
    }

    public void setCallback(av avVar) {
        this.e = avVar;
    }

    public au(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f = false;
        this.c = context;
        a();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.b;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.e eVar) {
        this.b.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.b.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.f fVar) {
        this.b.setOnSizeChangedListener(fVar);
    }

    protected void a() {
        this.b = new com.baidu.tbadk.widget.a(this.c);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.b);
        this.a = new ProgressBar(this.c, null, 16843399);
        this.a.setIndeterminateDrawable(this.c.getResources().getDrawable(com.baidu.tieba.u.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.a.setLayoutParams(layoutParams);
        this.a.setIndeterminate(true);
        addView(this.a);
    }

    public void a(String str, boolean z) {
        this.b.setTag(str);
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(getContext());
        if (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI || netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG) {
            if (this.d != null) {
                this.d.cancel();
            }
            if (str != null) {
                this.d = new aw(this, str, z);
                this.d.execute(new String[0]);
            }
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.b.setGifMaxUseableMem(i);
    }

    public void b() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public void c() {
        b();
        if (this.b != null) {
            this.b.j();
        }
        this.a.setVisibility(8);
    }

    public void d() {
        b();
        if (this.b != null) {
            this.b.k();
        }
        this.a.setVisibility(8);
    }

    public void e() {
        if (this.b != null && this.b.getImageType() == 1) {
            this.b.g();
        }
    }

    public void a(boolean z) {
        String str;
        if (this.b != null && (str = (String) this.b.getTag()) != null && this.b != null && this.d == null) {
            if (this.b.getImageType() == 1) {
                if (this.b.getGifCache() == null) {
                    this.d = new aw(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageType() == 2) {
                if (UtilHelper.getNetStatusInfo(getContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.d = new aw(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageBitmap() == null) {
                this.d = new aw(this, str, z);
                this.d.execute(new String[0]);
            }
        }
    }

    public int getImageType() {
        if (this.b != null) {
            return this.b.getImageType();
        }
        return 0;
    }

    public void setIsCdn(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(String str) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bg.f(str), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.b(true);
        cVar.d(false);
        cVar.a((Object) bArr);
        if (com.baidu.adp.lib.Disk.d.a().b(cVar)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (BdResourceLoaderNetHelperStatic.a()) {
                i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.d("wait exception. class is " + e.getClass().getName() + e.getMessage());
                }
            }
            if (cVar.g()) {
                return cVar.b();
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr, boolean z) {
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bg.f(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.b(true);
        cVar.a(bArr);
        com.baidu.adp.lib.Disk.d.a().b(cVar);
    }
}
