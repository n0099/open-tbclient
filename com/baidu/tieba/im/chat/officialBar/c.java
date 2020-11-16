package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes25.dex */
public class c {
    public static c jYt = new c();
    private com.baidu.adp.lib.d.b<MultiImageTextTopView> jYg;
    private com.baidu.adp.lib.d.b<MultiImageTextBottomView> jYh;
    private com.baidu.adp.lib.d.b<SingleImageTextView> jYi;

    private void fs(final Context context) {
        this.jYg = new com.baidu.adp.lib.d.b<MultiImageTextTopView>(new com.baidu.adp.lib.d.c<MultiImageTextTopView>() { // from class: com.baidu.tieba.im.chat.officialBar.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cOG */
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

    private void ft(final Context context) {
        this.jYh = new com.baidu.adp.lib.d.b<MultiImageTextBottomView>(new com.baidu.adp.lib.d.c<MultiImageTextBottomView>() { // from class: com.baidu.tieba.im.chat.officialBar.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cOH */
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

    private void fu(final Context context) {
        this.jYi = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<SingleImageTextView>() { // from class: com.baidu.tieba.im.chat.officialBar.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cOI */
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

    public com.baidu.adp.lib.d.b<MultiImageTextTopView> fv(Context context) {
        if (this.jYg == null) {
            fs(context);
        }
        return this.jYg;
    }

    public com.baidu.adp.lib.d.b<MultiImageTextBottomView> fw(Context context) {
        if (this.jYh == null) {
            ft(context);
        }
        return this.jYh;
    }

    public com.baidu.adp.lib.d.b<SingleImageTextView> fx(Context context) {
        if (this.jYi == null) {
            fu(context);
        }
        return this.jYi;
    }
}
