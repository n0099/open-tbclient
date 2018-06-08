package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {
    public static b eeK = new b();
    private com.baidu.adp.lib.e.b<SingleImageTextView> eeA;
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> eey;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> eez;

    private void bE(final Context context) {
        this.eey = new com.baidu.adp.lib.e.b<MultiImageTextTopView>(new com.baidu.adp.lib.e.c<MultiImageTextTopView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aFY */
            public MultiImageTextTopView mo9if() {
                return new MultiImageTextTopView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void q(MultiImageTextTopView multiImageTextTopView) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public MultiImageTextTopView r(MultiImageTextTopView multiImageTextTopView) {
                return multiImageTextTopView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public MultiImageTextTopView s(MultiImageTextTopView multiImageTextTopView) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.reset();
                }
                return multiImageTextTopView;
            }
        }, 1, 0) { // from class: com.baidu.tieba.im.chat.officialBar.b.2
        };
    }

    private void bF(final Context context) {
        this.eez = new com.baidu.adp.lib.e.b<MultiImageTextBottomView>(new com.baidu.adp.lib.e.c<MultiImageTextBottomView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aFZ */
            public MultiImageTextBottomView mo9if() {
                return new MultiImageTextBottomView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public void q(MultiImageTextBottomView multiImageTextBottomView) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: g */
            public MultiImageTextBottomView r(MultiImageTextBottomView multiImageTextBottomView) {
                return multiImageTextBottomView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: h */
            public MultiImageTextBottomView s(MultiImageTextBottomView multiImageTextBottomView) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.reset();
                }
                return multiImageTextBottomView;
            }
        }, 9, 0) { // from class: com.baidu.tieba.im.chat.officialBar.b.4
        };
    }

    private void bG(final Context context) {
        this.eeA = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<SingleImageTextView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aGa */
            public SingleImageTextView mo9if() {
                return new SingleImageTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void q(SingleImageTextView singleImageTextView) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public SingleImageTextView r(SingleImageTextView singleImageTextView) {
                return singleImageTextView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public SingleImageTextView s(SingleImageTextView singleImageTextView) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.reset();
                }
                return singleImageTextView;
            }
        }, 1, 0);
    }

    public com.baidu.adp.lib.e.b<MultiImageTextTopView> bH(Context context) {
        if (this.eey == null) {
            bE(context);
        }
        return this.eey;
    }

    public com.baidu.adp.lib.e.b<MultiImageTextBottomView> bI(Context context) {
        if (this.eez == null) {
            bF(context);
        }
        return this.eez;
    }

    public com.baidu.adp.lib.e.b<SingleImageTextView> bJ(Context context) {
        if (this.eeA == null) {
            bG(context);
        }
        return this.eeA;
    }
}
