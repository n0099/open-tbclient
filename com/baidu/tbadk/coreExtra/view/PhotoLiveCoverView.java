package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.PhotoLiveCardData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class PhotoLiveCoverView extends RelativeLayout {
    private RelativeLayout bnR;
    private TbImageView bnS;
    private TextView bnT;
    private TextView bnU;
    private TextView bnV;
    private boolean bns;
    private boolean bnt;
    private int bob;
    private ArrayList<Integer> boc;
    private boolean bog;
    private int bon;
    private int boo;
    private int bop;
    private int boq;
    private int bor;
    private int bos;
    private int bot;
    private int bou;
    private int bov;
    private int bow;
    private int box;
    private int size;

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bob = 0;
        this.bns = true;
        this.bnt = true;
        this.bog = true;
        this.boc = new ArrayList<>();
        this.bon = (int) context.getResources().getDimension(d.e.ds80);
        this.boo = (int) context.getResources().getDimension(d.e.ds280);
        this.bop = (int) context.getResources().getDimension(d.e.ds170);
        this.boq = (int) context.getResources().getDimension(d.e.ds320);
        this.bor = (int) context.getResources().getDimension(d.e.ds200);
        this.bos = (int) context.getResources().getDimension(d.e.ds60);
        this.bot = (int) context.getResources().getDimension(d.e.ds120);
        this.bou = (int) context.getResources().getDimension(d.e.ds160);
        this.bov = (int) context.getResources().getDimension(d.e.ds220);
        this.bow = (int) context.getResources().getDimension(d.e.ds240);
        this.box = (int) context.getResources().getDimension(d.e.ds180);
        this.size = (int) context.getResources().getDimension(d.e.ds8);
        init(context);
    }

    public PhotoLiveCoverView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoLiveCoverView(Context context) {
        this(context, null, 0);
    }

    private void init(Context context) {
        this.bnR = (RelativeLayout) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(d.h.photo_live_card_cover_and_expression, this).findViewById(d.g.photo_live_card_cover_and_expression);
        Jr();
    }

    public void setData(PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            a(this.bns, this.bnt, photoLiveCardData);
        }
    }

    private void a(boolean z, boolean z2, PhotoLiveCardData photoLiveCardData) {
        if (photoLiveCardData != null) {
            if (z && this.bog) {
                this.bnR.setVisibility(0);
                setCover(photoLiveCardData.getPhotoLiveCover());
                setExpression(photoLiveCardData);
            } else if (this.bnR != null) {
                this.bnR.setVisibility(8);
            }
        }
    }

    private void Jr() {
        if (this.bnR != null) {
            this.bnS = (TbImageView) this.bnR.findViewById(d.g.live_cover);
            this.bnS.setGifIconSupport(false);
            Js();
        }
    }

    private void Js() {
        if (this.bnR != null) {
            this.bnT = (TextView) this.bnR.findViewById(d.g.first_style_first_expression);
            this.bnU = (TextView) this.bnR.findViewById(d.g.first_style_second_expression);
            this.bnV = (TextView) this.bnR.findViewById(d.g.first_style_third_expression);
        }
    }

    private void setExpression(PhotoLiveCardData photoLiveCardData) {
        this.boc.clear();
        Ju();
        if (photoLiveCardData != null && photoLiveCardData.getExpressionDatas() != null) {
            int size = photoLiveCardData.getExpressionDatas().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = photoLiveCardData.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, photoLiveCardData.getExpressionDatas(), i);
                }
            }
            Jt();
        }
    }

    private void Ju() {
        this.bnT.setText("");
        this.bnU.setText("");
        this.bnV.setText("");
        if (this.bnT.getVisibility() == 8) {
            this.bnT.setVisibility(0);
        }
        if (this.bnU.getVisibility() == 8) {
            this.bnU.setVisibility(0);
        }
        if (this.bnV.getVisibility() == 8) {
            this.bnV.setVisibility(0);
        }
        this.boc.add(Integer.valueOf(this.bnT.getId()));
        this.boc.add(Integer.valueOf(this.bnU.getId()));
        this.boc.add(Integer.valueOf(this.bnV.getId()));
    }

    private void a(e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.ak(eVar.getLabelName(), String.valueOf(eVar.Jk())));
            hq(textView.getId());
        }
    }

    private void a(int i, ArrayList<e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.bob) {
                case 0:
                    a(this.bon, this.boo, this.bnT);
                    a(this.bop, this.boq, this.bnU);
                    a(this.bor, this.bos, this.bnV);
                    break;
                case 1:
                    a(this.bos, this.bot, this.bnT);
                    a(this.bou, this.bos, this.bnU);
                    a(this.bov, this.boq, this.bnV);
                    break;
                case 2:
                    a(this.bos, this.bow, this.bnT);
                    a(this.box, this.bos, this.bnU);
                    a(this.bov, this.boq, this.bnV);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bnT);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bnU);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bnV);
            }
        }
    }

    private void setCover(String str) {
        this.bnS.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.bnS.startLoad(str, 10, false);
        } else {
            this.bnS.startLoad(null, 10, false);
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private void Jt() {
        if (this.boc.size() != 0) {
            int size = this.boc.size();
            for (int i = 0; i < size; i++) {
                if (this.boc.get(i).intValue() == this.bnT.getId()) {
                    this.bnT.setVisibility(8);
                } else if (this.boc.get(i).intValue() == this.bnU.getId()) {
                    this.bnU.setVisibility(8);
                } else if (this.boc.get(i).intValue() == this.bnV.getId()) {
                    this.bnV.setVisibility(8);
                }
            }
        }
    }

    private void hq(int i) {
        if (this.boc.size() != 0) {
            int size = this.boc.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.boc.get(i2).intValue() == i) {
                    this.boc.remove(i2);
                    return;
                }
            }
        }
    }

    private boolean a(e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    public void setShowExpression(boolean z) {
        this.bnt = z;
    }

    public void setShowImage(boolean z) {
        this.bog = z;
    }

    public void setChooseStyle(int i) {
        this.bob = i;
    }
}
