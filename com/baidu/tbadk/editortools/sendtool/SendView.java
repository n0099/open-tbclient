package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import d.a.m0.w.n;
import d.a.n0.e3.c;
/* loaded from: classes3.dex */
public class SendView extends TextView implements n {
    public static int j = 1;
    public static int k;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f12870e;

    /* renamed from: f  reason: collision with root package name */
    public int f12871f;

    /* renamed from: g  reason: collision with root package name */
    public boolean[] f12872g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f12873h;

    /* renamed from: i  reason: collision with root package name */
    public int f12874i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SendView.this.d(new d.a.m0.w.a(8, -1, null));
        }
    }

    public SendView(Context context) {
        super(context);
        this.f12872g = new boolean[]{false, false, false, false, false};
        this.f12873h = new int[]{0, 0};
        this.f12874i = k;
        setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds17), context.getResources().getDimensionPixelSize(R.dimen.ds28), context.getResources().getDimensionPixelSize(R.dimen.ds10), context.getResources().getDimensionPixelSize(R.dimen.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        setTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        setText(R.string.send_post);
        setOnClickListener(new a());
    }

    public void a(int i2) {
        if (i2 == k) {
            boolean[] zArr = this.f12872g;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                setEnabled(false);
            } else {
                setEnabled(true);
            }
        } else if (i2 == j) {
            if (this.f12872g[1]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }

    @Override // d.a.m0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.a.m0.w.n
    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.f12870e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.f12871f;
    }

    @Override // d.a.m0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.m0.w.n
    public void init() {
        setClickable(false);
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f54518a;
        if (i2 == 4) {
            Object obj = aVar.f54520c;
            if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
                this.f12872g[0] = true;
            } else {
                this.f12872g[0] = false;
            }
        } else if (i2 == 39 || i2 == 28) {
            this.f12872g[3] = true;
        } else if (i2 != 29) {
            switch (i2) {
                case 9:
                    boolean[] zArr = this.f12872g;
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    zArr[3] = false;
                    zArr[4] = false;
                    int[] iArr = this.f12873h;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    break;
                case 10:
                    this.f12872g[2] = true;
                    break;
                case 11:
                    this.f12872g[2] = false;
                    break;
                case 12:
                    Object obj2 = aVar.f54520c;
                    if (obj2 instanceof d.a.m0.w.r.a) {
                        d.a.m0.w.r.a aVar2 = (d.a.m0.w.r.a) obj2;
                        WriteImagesInfo writeImagesInfo = aVar2.f54541a;
                        if (writeImagesInfo != null) {
                            if (writeImagesInfo.getChosedFiles() != null) {
                                this.f12873h[0] = aVar2.f54541a.getChosedFiles().size();
                            } else {
                                this.f12873h[0] = 0;
                            }
                        }
                        if (this.f12873h[0] > 0) {
                            this.f12872g[1] = true;
                            break;
                        } else {
                            this.f12872g[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr2 = this.f12873h;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] > 0) {
                        this.f12872g[1] = true;
                        break;
                    } else {
                        this.f12872g[1] = false;
                        break;
                    }
            }
        } else {
            this.f12872g[3] = false;
        }
        a(this.f12874i);
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
        int color = SkinManager.getColor(i2, R.color.CAM_X0302);
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{c.a(color, SkinManager.RESOURCE_ALPHA_DISABLE), c.a(color, SkinManager.RESOURCE_ALPHA_PRESS), color}));
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f12870e = editorTools;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.f12871f = i2;
    }

    public void setType(int i2) {
        this.f12874i = i2;
    }
}
