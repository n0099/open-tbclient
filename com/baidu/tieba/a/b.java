package com.baidu.tieba.a;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.f;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.widget.ListView.a<f, com.baidu.tbadk.j.c> {
    private com.baidu.tieba.story.c aXH;
    private TbPageContext<?> ako;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), f.azl, bdUniqueId);
        this.ako = tbPageContext;
    }

    public void a(com.baidu.tieba.story.c cVar) {
        this.aXH = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: c */
    public com.baidu.tbadk.j.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.j.c(LayoutInflater.from(this.ako.getPageActivity()).inflate(d.j.entrance_pic_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, com.baidu.tbadk.j.c cVar) {
        if (cVar == null || fVar == null) {
            return null;
        }
        a(cVar, (f) getItem(i), view, i);
        return view;
    }

    private void a(com.baidu.tbadk.j.c cVar, final f fVar, View view, final int i) {
        if (cVar != null && fVar != null) {
            cVar.aEO.getInnerImg().setIsRound(true);
            cVar.aEO.getInnerImg().c(fVar.portrait, 12, false);
            cVar.aEO.setOuterColor(d.e.cp_link_tip_g);
            if (fVar.azh == i) {
                if (fVar.azi == 1) {
                    cVar.aEO.a(null, i);
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar.user_id))) {
                        cVar.setStatus(fVar.has_read != 1 ? 0 : 2);
                        cVar.mName.setText(1 == fVar.mStatus ? this.mContext.getString(d.l.sending_type) : this.mContext.getString(d.l.my_story));
                    } else {
                        cVar.mName.setText(fVar.user_name);
                    }
                } else {
                    cVar.aEO.wr();
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar.user_id))) {
                        if (fVar.mStatus == 3) {
                            cVar.aEO.aK(false);
                            cVar.mName.setText(this.mContext.getString(d.l.post_story_fail));
                            cVar.setStatus(3);
                        } else {
                            if (fVar.has_read == 1) {
                                cVar.setStatus(2);
                                cVar.aEO.aJ(true);
                            } else {
                                cVar.setStatus(0);
                                cVar.aEO.aJ(false);
                            }
                            cVar.aEO.aK(true);
                            cVar.mName.setText(this.mContext.getString(d.l.my_story));
                        }
                    } else {
                        if (fVar.has_read == 1) {
                            cVar.setStatus(2);
                            cVar.aEO.aJ(true);
                        } else {
                            cVar.setStatus(0);
                            cVar.aEO.aJ(false);
                        }
                        cVar.mName.setText(fVar.user_name);
                    }
                    fVar.azh = -1;
                }
            } else {
                cVar.aEO.wr();
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar.user_id))) {
                    if (fVar.mStatus == 3) {
                        cVar.aEO.aK(false);
                        cVar.mName.setText(this.mContext.getString(d.l.post_story_fail));
                        cVar.setStatus(3);
                    } else {
                        if (fVar.has_read == 1) {
                            cVar.setStatus(2);
                            cVar.aEO.aJ(true);
                        } else {
                            cVar.setStatus(0);
                            cVar.aEO.aJ(false);
                        }
                        cVar.mName.setText(this.mContext.getString(d.l.my_story));
                    }
                } else {
                    if (fVar.has_read == 1) {
                        cVar.setStatus(2);
                        cVar.aEO.aJ(true);
                    } else {
                        cVar.setStatus(0);
                        cVar.aEO.aJ(false);
                    }
                    cVar.mName.setText(fVar.user_name);
                }
            }
            cVar.aEO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.b.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        view2.setScaleX(0.8f);
                        view2.setScaleY(0.8f);
                    } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                        view2.setScaleX(1.0f);
                        view2.setScaleY(1.0f);
                    }
                    return view2.onTouchEvent(motionEvent);
                }
            });
            cVar.aEO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.aXH.a(fVar, i);
                }
            });
            cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
