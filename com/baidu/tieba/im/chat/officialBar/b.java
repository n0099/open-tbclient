package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
/* loaded from: classes3.dex */
public class b {
    public static b eCV = new b();
    private com.baidu.adp.lib.e.b<MultiImageTextTopView> eCI;
    private com.baidu.adp.lib.e.b<MultiImageTextBottomView> eCJ;
    private com.baidu.adp.lib.e.b<SingleImageTextView> eCK;

    private void ct(final Context context) {
        this.eCI = new com.baidu.adp.lib.e.b<MultiImageTextTopView>(new com.baidu.adp.lib.e.c<MultiImageTextTopView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aMG */
            public MultiImageTextTopView jz() {
                return new MultiImageTextTopView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public void u(MultiImageTextTopView multiImageTextTopView) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public MultiImageTextTopView v(MultiImageTextTopView multiImageTextTopView) {
                return multiImageTextTopView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public MultiImageTextTopView w(MultiImageTextTopView multiImageTextTopView) {
                if (multiImageTextTopView instanceof MultiImageTextTopView) {
                    multiImageTextTopView.reset();
                }
                return multiImageTextTopView;
            }
        }, 1, 0) { // from class: com.baidu.tieba.im.chat.officialBar.b.2
        };
    }

    private void cu(final Context context) {
        this.eCJ = new com.baidu.adp.lib.e.b<MultiImageTextBottomView>(new com.baidu.adp.lib.e.c<MultiImageTextBottomView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aMH */
            public MultiImageTextBottomView jz() {
                return new MultiImageTextBottomView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: f */
            public void u(MultiImageTextBottomView multiImageTextBottomView) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: g */
            public MultiImageTextBottomView v(MultiImageTextBottomView multiImageTextBottomView) {
                return multiImageTextBottomView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: h */
            public MultiImageTextBottomView w(MultiImageTextBottomView multiImageTextBottomView) {
                if (multiImageTextBottomView instanceof MultiImageTextBottomView) {
                    multiImageTextBottomView.reset();
                }
                return multiImageTextBottomView;
            }
        }, 9, 0) { // from class: com.baidu.tieba.im.chat.officialBar.b.4
        };
    }

    private void cv(final Context context) {
        this.eCK = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<SingleImageTextView>() { // from class: com.baidu.tieba.im.chat.officialBar.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: aMI */
            public SingleImageTextView jz() {
                return new SingleImageTextView(context);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: a */
            public void u(SingleImageTextView singleImageTextView) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.reset();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: b */
            public SingleImageTextView v(SingleImageTextView singleImageTextView) {
                return singleImageTextView;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public SingleImageTextView w(SingleImageTextView singleImageTextView) {
                if (singleImageTextView instanceof SingleImageTextView) {
                    singleImageTextView.reset();
                }
                return singleImageTextView;
            }
        }, 1, 0);
    }

    public com.baidu.adp.lib.e.b<MultiImageTextTopView> cw(Context context) {
        if (this.eCI == null) {
            ct(context);
        }
        return this.eCI;
    }

    public com.baidu.adp.lib.e.b<MultiImageTextBottomView> cx(Context context) {
        if (this.eCJ == null) {
            cu(context);
        }
        return this.eCJ;
    }

    public com.baidu.adp.lib.e.b<SingleImageTextView> cy(Context context) {
        if (this.eCK == null) {
            cv(context);
        }
        return this.eCK;
    }
}
