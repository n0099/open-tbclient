package com.baidu.tieba.ala.a;

import android.animation.FloatEvaluator;
/* loaded from: classes4.dex */
public class a extends FloatEvaluator {
    private float aUS = 0.6818182f;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Number number, Number number2) {
        return f <= this.aUS ? Float.valueOf((f / this.aUS) * 1.3f) : Float.valueOf(1.3f - ((0.3f * (f - this.aUS)) / (1.0f - this.aUS)));
    }
}
