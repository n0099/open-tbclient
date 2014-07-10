package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class MultiContentView extends LinearLayout {
    private Context a;
    private View b;
    private LinearLayout c;
    private com.baidu.adp.lib.d.b<h> d;
    private com.baidu.adp.lib.d.b<c> e;
    private com.baidu.adp.lib.d.b<bf> f;
    private com.baidu.adp.lib.b.b g;
    private int h;
    private boolean i;
    private String j;
    private int k;

    public MultiContentView(Context context) {
        super(context);
        this.g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        a();
    }

    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        a();
    }

    private void a() {
        this.b = View.inflate(this.a, com.baidu.tieba.w.msg_multi_pic_text_content_view, this);
        this.c = (LinearLayout) this.b.findViewById(com.baidu.tieba.v.view_container);
        this.d = m.a().a(this.a);
        this.e = m.a().b(this.a);
        this.f = m.a().c(this.a);
        this.c.setOnHierarchyChangeListener(new b(this));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.c.addView(view);
    }

    public void a(List<t> list, View view) {
        this.c.removeAllViews();
        if (list != null && list.size() != 0) {
            int size = list.size();
            if (size == 1) {
                a(list.get(0), getSingleView(), view);
                return;
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    a(list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    a(list.get(i), getBottomView(), view);
                } else {
                    a(list.get(i), getMidView(), view);
                }
            }
        }
    }

    private h getTopView() {
        h hVar = null;
        if (this.d != null) {
            hVar = this.d.a();
        }
        if (hVar == null || hVar.getParent() != null) {
            hVar = new h(this.a);
        }
        hVar.setOnItemViewLongClickListener(this.g);
        hVar.setPosition(this.h);
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                hVar.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_top_bg_1);
            } else if (this.k == 1) {
                hVar.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_top_bg_1);
            }
            hVar.a(true);
        } else {
            if (this.k == 2) {
                hVar.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_top_bg);
            } else if (this.k == 1) {
                hVar.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_top_bg);
            }
            hVar.a(false);
        }
        return hVar;
    }

    private void a(t tVar, h hVar, View view) {
        if (tVar != null && hVar != null) {
            hVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            hVar.setTime(this.j);
            hVar.a(tVar, view);
            this.c.addView(hVar);
        }
    }

    private c getCommonBottomView() {
        c cVar = null;
        if (this.e != null) {
            cVar = this.e.a();
        }
        if (cVar == null || cVar.getParent() != null) {
            cVar = new c(this.a);
        }
        cVar.setOnItemViewLongClickListener(this.g);
        cVar.setPosition(this.h);
        return cVar;
    }

    private c getMidView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_mid_bg_1);
            } else if (this.k == 1) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_mid_bg_1);
            }
            commonBottomView.a(true);
            return commonBottomView;
        }
        if (this.k == 2) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_mid_bg);
        } else if (this.k == 1) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_mid_bg);
        }
        commonBottomView.a(false);
        return commonBottomView;
    }

    private c getBottomView() {
        c commonBottomView = getCommonBottomView();
        if (commonBottomView == null) {
            return null;
        }
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_bottom_bg_1);
            } else if (this.k == 1) {
                commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_bottom_bg_1);
            }
            commonBottomView.a(true);
            return commonBottomView;
        }
        if (this.k == 2) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_bottom_bg);
        } else if (this.k == 1) {
            commonBottomView.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_bottom_bg);
        }
        commonBottomView.a(false);
        return commonBottomView;
    }

    private void a(t tVar, c cVar, View view) {
        if (tVar != null && cVar != null) {
            cVar.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.a.getResources().getDimension(com.baidu.tieba.t.multi_bottom_height)));
            cVar.a(tVar, view);
            this.c.addView(cVar);
        }
    }

    private bf getSingleView() {
        bf bfVar = null;
        if (this.f != null) {
            bfVar = this.f.a();
        }
        if (bfVar == null || bfVar.getParent() == null) {
            bfVar = new bf(this.a);
        }
        bfVar.setOnItemViewLongClickListener(this.g);
        bfVar.setPosition(this.h);
        if (TbadkApplication.m252getInst().getSkinType() == 1 && this.i) {
            if (this.k == 2) {
                bfVar.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_single_bg_1);
            } else if (this.k == 1) {
                bfVar.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_single_bg_1);
            }
            bfVar.a(true);
        } else {
            if (this.k == 2) {
                bfVar.setBackgroundResource(com.baidu.tieba.u.selector_history_multi_single_bg);
            } else if (this.k == 1) {
                bfVar.setBackgroundResource(com.baidu.tieba.u.selector_msg_multi_single_bg);
            }
            bfVar.a(false);
        }
        return bfVar;
    }

    private void a(t tVar, bf bfVar, View view) {
        if (tVar != null && bfVar != null) {
            bfVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            bfVar.setTime(this.j);
            bfVar.a(tVar, view);
            this.c.addView(bfVar);
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.g = bVar;
    }

    public void setPosition(int i) {
        this.h = i;
    }

    public void setNeedNightMode(boolean z) {
        this.i = z;
    }

    public void setTime(String str) {
        this.j = str;
    }

    public void setType(int i) {
        this.k = i;
    }
}
