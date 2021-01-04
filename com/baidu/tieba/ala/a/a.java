package com.baidu.tieba.ala.a;

import android.animation.FloatEvaluator;
/* loaded from: classes11.dex */
public class a extends FloatEvaluator {
    private float bek = 0.6818182f;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        return f <= this.bek ? Float.valueOf((f / this.bek) * 1.3f) : Float.valueOf(1.3f - ((0.3f * (f - this.bek)) / (1.0f - this.bek)));
    }
}
