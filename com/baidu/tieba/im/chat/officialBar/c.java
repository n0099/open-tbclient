package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes8.dex */
public class c {
    public static c kCi = new c();
    private com.baidu.adp.lib.d.b<MultiImageTextTopView> kBV;
    private com.baidu.adp.lib.d.b<MultiImageTextBottomView> kBW;
    private com.baidu.adp.lib.d.b<SingleImageTextView> kBX;

    private void gq(final Context context) {
        this.kBV = new com.baidu.adp.lib.d.b<MultiImageTextTopView>(new com.baidu.adp.lib.d.c<MultiImageTextTopView>() { // from class: com.baidu.tieba.im.chat.officialBar.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cUO */
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
        }, 1, 0) { // from class: com.baidu.tieba.im.chat.officialBar.c.2
        };
    }

    private void gr(final Context context) {
        this.kBW = new com.baidu.adp.lib.d.b<MultiImageTextBottomView>(new com.baidu.adp.lib.d.c<MultiImageTextBottomView>() { // from class: com.baidu.tieba.im.chat.officialBar.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cUP */
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
        }, 9, 0) { // from class: com.baidu.tieba.im.chat.officialBar.c.4
        };
    }

    private void gs(final Context context) {
        this.kBX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<SingleImageTextView>() { // from class: com.baidu.tieba.im.chat.officialBar.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cUQ */
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

    public com.baidu.adp.lib.d.b<MultiImageTextTopView> gt(Context context) {
        if (this.kBV == null) {
            gq(context);
        }
        return this.kBV;
    }

    public com.baidu.adp.lib.d.b<MultiImageTextBottomView> gu(Context context) {
        if (this.kBW == null) {
            gr(context);
        }
        return this.kBW;
    }

    public com.baidu.adp.lib.d.b<SingleImageTextView> gv(Context context) {
        if (this.kBX == null) {
            gs(context);
        }
        return this.kBX;
    }
}
