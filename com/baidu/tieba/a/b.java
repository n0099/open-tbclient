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
    private com.baidu.tieba.story.c aYG;
    private TbPageContext<?> mF;

    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), f.azP, bdUniqueId);
        this.mF = tbPageContext;
    }

    public void a(com.baidu.tieba.story.c cVar) {
        this.aYG = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: d */
    public com.baidu.tbadk.j.c onCreateViewHolder(ViewGroup viewGroup) {
        return new com.baidu.tbadk.j.c(LayoutInflater.from(this.mF.getPageActivity()).inflate(d.j.entrance_pic_item, (ViewGroup) null));
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
            cVar.aFy.getInnerImg().setIsRound(true);
            cVar.aFy.getInnerImg().c(fVar.portrait, 12, false);
            cVar.aFy.setOuterColor(d.e.cp_link_tip_g);
            if (fVar.azL == i) {
                if (fVar.azM == 1) {
                    cVar.aFy.a(null, i);
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar.user_id))) {
                        cVar.setStatus(fVar.has_read != 1 ? 0 : 2);
                        cVar.mName.setText(1 == fVar.mStatus ? this.mContext.getString(d.l.sending_type) : this.mContext.getString(d.l.my_story));
                    } else {
                        cVar.mName.setText(fVar.user_name);
                    }
                } else {
                    cVar.aFy.wz();
                    if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar.user_id))) {
                        if (fVar.mStatus == 3) {
                            cVar.aFy.aK(false);
                            cVar.mName.setText(this.mContext.getString(d.l.post_story_fail));
                            cVar.setStatus(3);
                        } else {
                            if (fVar.has_read == 1) {
                                cVar.setStatus(2);
                                cVar.aFy.aJ(true);
                            } else {
                                cVar.setStatus(0);
                                cVar.aFy.aJ(false);
                            }
                            cVar.aFy.aK(true);
                            cVar.mName.setText(this.mContext.getString(d.l.my_story));
                        }
                    } else {
                        if (fVar.has_read == 1) {
                            cVar.setStatus(2);
                            cVar.aFy.aJ(true);
                        } else {
                            cVar.setStatus(0);
                            cVar.aFy.aJ(false);
                        }
                        cVar.mName.setText(fVar.user_name);
                    }
                    fVar.azL = -1;
                }
            } else {
                cVar.aFy.wz();
                if (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(fVar.user_id))) {
                    if (fVar.mStatus == 3) {
                        cVar.aFy.aK(false);
                        cVar.mName.setText(this.mContext.getString(d.l.post_story_fail));
                        cVar.setStatus(3);
                    } else {
                        if (fVar.has_read == 1) {
                            cVar.setStatus(2);
                            cVar.aFy.aJ(true);
                        } else {
                            cVar.setStatus(0);
                            cVar.aFy.aJ(false);
                        }
                        cVar.mName.setText(this.mContext.getString(d.l.my_story));
                    }
                } else {
                    if (fVar.has_read == 1) {
                        cVar.setStatus(2);
                        cVar.aFy.aJ(true);
                    } else {
                        cVar.setStatus(0);
                        cVar.aFy.aJ(false);
                    }
                    cVar.mName.setText(fVar.user_name);
                }
            }
            cVar.aFy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.a.b.1
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
            cVar.aFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.aYG.a(fVar, i);
                }
            });
            cVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
