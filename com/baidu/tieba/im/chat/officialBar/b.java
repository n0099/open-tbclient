package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes13.dex */
public class b {
    public static b huh = new b();
    private com.baidu.adp.lib.d.b<MultiImageTextTopView> htU;
    private com.baidu.adp.lib.d.b<MultiImageTextBottomView> htV;
    private com.baidu.adp.lib.d.b<SingleImageTextView> htW;

    private void eU(final Context context) {
        this.htU = new com.baidu.adp.lib.d.b<MultiImageTextTopView>(new com.baidu.adp.lib.d.c<MultiImageTextTopView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bSv */
            public MultiImageTextTopView makeObject() {
                return new MultiImageTextTopView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public void destroyObject(MultiImageTextTopView multiImageTextTopView) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public MultiImageTextTopView activateObject(MultiImageTextTopView multiImageTextTopView) {
                return multiImageTextTopView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: f */
            public MultiImageTextTopView passivateObject(MultiImageTextTopView multiImageTextTopView) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.reset();
                }
                return multiImageTextTopView;
            }
        }, 1, 0) { // from class: com.baidu.tieba.im.chat.officialBar.b.2
        };
    }

    private void eV(final Context context) {
        this.htV = new com.baidu.adp.lib.d.b<MultiImageTextBottomView>(new com.baidu.adp.lib.d.c<MultiImageTextBottomView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bSw */
            public MultiImageTextBottomView makeObject() {
                return new MultiImageTextBottomView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: f */
            public void destroyObject(MultiImageTextBottomView multiImageTextBottomView) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: g */
            public MultiImageTextBottomView activateObject(MultiImageTextBottomView multiImageTextBottomView) {
                return multiImageTextBottomView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: h */
            public MultiImageTextBottomView passivateObject(MultiImageTextBottomView multiImageTextBottomView) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.reset();
                }
                return multiImageTextBottomView;
            }
        }, 9, 0) { // from class: com.baidu.tieba.im.chat.officialBar.b.4
        };
    }

    private void eW(final Context context) {
        this.htW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<SingleImageTextView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: bSx */
            public SingleImageTextView makeObject() {
                return new SingleImageTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: a */
            public void destroyObject(SingleImageTextView singleImageTextView) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: b */
            public SingleImageTextView activateObject(SingleImageTextView singleImageTextView) {
                return singleImageTextView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public SingleImageTextView passivateObject(SingleImageTextView singleImageTextView) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.reset();
                }
                return singleImageTextView;
            }
        }, 1, 0);
    }

    public com.baidu.adp.lib.d.b<MultiImageTextTopView> eX(Context context) {
        if (this.htU == null) {
            eU(context);
        }
        return this.htU;
    }

    public com.baidu.adp.lib.d.b<MultiImageTextBottomView> eY(Context context) {
        if (this.htV == null) {
            eV(context);
        }
        return this.htV;
    }

    public com.baidu.adp.lib.d.b<SingleImageTextView> eZ(Context context) {
        if (this.htW == null) {
            eW(context);
        }
        return this.htW;
    }
}
